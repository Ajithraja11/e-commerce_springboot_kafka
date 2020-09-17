package com.demo.order.repository;

import java.sql.SQLException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import com.demo.entity.Order;
import com.demo.order.dao.OrderDao;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class OrderDaoImplementation 
{
	@Autowired
	OrderDao orderDao;
	
	@Retryable(value = { SQLException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public void createOrder(Order newOrder)throws Exception  {
		
		orderDao.save(newOrder);
		log.info("Inside Repository layer");	
	}

	@Retryable(value = { SQLException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
	public Optional<Order> getOrder(int orderID)throws Exception 
	{
		log.info("Inside Repository layer");
		return orderDao.findById(orderID);
	}

}
