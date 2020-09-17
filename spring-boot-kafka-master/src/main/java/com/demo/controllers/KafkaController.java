package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Order;
import com.demo.entity.StatusUpdate;
import com.demo.service.Producer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/publish")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/createorder")
    public ResponseEntity<Object> createOrders(@RequestBody Order newOrders[]) 
    {
    	log.info("Inside Publisher controller (createOrders)");
    	for(Order order:newOrders)
    	{
    		this.producer.createOrder(order);
    	}
        return new ResponseEntity<Object>("Order(s) received. Processing the order(s)",HttpStatus.ACCEPTED); 
    }
    
    @PostMapping("/updateStatus")
    public ResponseEntity<Object> updateStatus(@RequestBody StatusUpdate statusUpdate) {
    
    	log.info("Inside Publisher Controller (updateStatus)");
    	this.producer.updateStatus(statusUpdate);
        return new ResponseEntity<Object>("StatusUpdate(s) received. Processing the StatusUpdate(s)",HttpStatus.ACCEPTED); 
    }   
}
