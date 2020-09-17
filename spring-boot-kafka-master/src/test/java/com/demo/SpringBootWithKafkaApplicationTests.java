package com.demo;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.demo.entity.Order;
import com.demo.order.repository.OrderDaoImplementation;



@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("deprecation")
public class SpringBootWithKafkaApplicationTests {

	@Mock
	OrderDaoImplementation orderDao;
	
	@Test
	public void testCreateOrder() 
	{
		Order newOrder=new Order();
		try {
			orderDao.createOrder(newOrder);
			return;
		}
		catch(Exception e)
		{
			 Assert.isTrue(false);
		}
	}
	
	@Test
	public void testgetOrder()
	{
		Optional<Order> order = null;
		try {
			Mockito.doReturn(order).
			when(orderDao).getOrder(1);
			
			assertEquals(order,
					(orderDao.getOrder(1)));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
