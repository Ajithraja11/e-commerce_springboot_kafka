package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.entity.Order;
import com.demo.entity.StatusUpdate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Producer {
 
	@Value("${order.topic}")
    private static  String ORDER_TOPIC ;
    
	@Value("${statusupdate.topic}")
    private static  String STATUS_TOPIC;

    @Autowired
    @Qualifier("orderProducer")
    private KafkaTemplate<String, Order> kafkaTemplateOrderCreation;

    @Autowired
    @Qualifier("StatusUpdateProducer")
    private KafkaTemplate<String, StatusUpdate> kafkaTemplateStatusUpdate;

    public void createOrder(Order newOrder)
    {
        this.kafkaTemplateOrderCreation.send(ORDER_TOPIC, newOrder);
        log.info("Publishing the order "+newOrder);
    }

	public void updateStatus(StatusUpdate statusUpdate) 
	{
		this.kafkaTemplateStatusUpdate.send(STATUS_TOPIC,statusUpdate);
		log.info("Publishing the StstusUpdate "+statusUpdate);
		
	}
}
