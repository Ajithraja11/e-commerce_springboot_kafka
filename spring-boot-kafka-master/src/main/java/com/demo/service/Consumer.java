package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.entity.Order;
import com.demo.entity.StatusUpdate;
import com.demo.order.repository.OrderDaoImplementation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Consumer {

	@Autowired
	OrderDaoImplementation orderRepo;
	
    @KafkaListener(topics = "orderCreate", groupId = "createOrder",containerFactory="kafkaListenerContainerFactory")
    public void consume(Order newOrder)
    {
        try
        {
        	orderRepo.createOrder(newOrder);
        	log.info("Order stored in the database successfully OrderID : "+newOrder.getOrder_id());
        }
        catch(Exception e)
        {
        	log.error("Exception occured while adding the order into the database "+newOrder.toString());
        }
    }
    
    @KafkaListener(topics = "statusUpdate", groupId = "statusUpdate",containerFactory="kafkaListenerContainerFactory")
    public void consumeStatusUpdate(StatusUpdate statusUpdate) 
    {
    	int[] orderIds=statusUpdate.getOrderIds();
    	for(int orderID:orderIds)
    	{
    		try
    		{
	    		 Optional<Order> order=orderRepo.getOrder(orderID);
	    		 if(order.isPresent())
	    		 {
	    			 Order currOrder= order.get();
	    			 currOrder.setOrder_status(statusUpdate.getNewStatus());
	    			 log.info("Order Status updated for the ID "+orderID);
	    		 }
	    		 else
	    		 {
	    			 log.warn("OrderID "+orderID+" is not available in the database");
	    		 }
    		}
    		catch(Exception e)
    		{
    			log.error("Exception occured while updating status for the OrderID "+orderID);
    		}
    	}
    }    
}
