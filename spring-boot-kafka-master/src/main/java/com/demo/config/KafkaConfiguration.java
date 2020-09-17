package com.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.demo.entity.Order;
import com.demo.entity.StatusUpdate;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, Order> producerFactoryOrderCreation()
	{
		Map<String,Object> config=new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092" );
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean(name = "orderProducer")
	public KafkaTemplate<String, Order> kafkaTemplate()
	{
		return new KafkaTemplate<String,Order>(producerFactoryOrderCreation());
	}
	
	@Bean
	public ProducerFactory<String, StatusUpdate> producerFactoryStatusUpdate()
	{
		Map<String,Object> config=new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092" );
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean(name = "StatusUpdateProducer")
	public KafkaTemplate<String, StatusUpdate> kafkaTemplateStatusUpdate()
	{
		return new KafkaTemplate<String,StatusUpdate>(producerFactoryStatusUpdate());
	}
	
	@Bean
	public ConsumerFactory<String, Order> consumerFactoryOrder()
	{
		Map<String,Object> config=new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092" );
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES,"com.demo.order" );
		
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
				new JsonDeserializer<>(Order.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Order> kafkaListenerContainerFactory() 
	{
		ConcurrentKafkaListenerContainerFactory<String, Order> factory=new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryOrder());
		
		return factory;
	}
	
	@Bean
	public ConsumerFactory<String, StatusUpdate> consumerFactoryStatusUpdate()
	{
		Map<String,Object> config=new HashMap<>();
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092" );
		config.put(ConsumerConfig.GROUP_ID_CONFIG,"group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES,"com.demo.order" );
		
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
				new JsonDeserializer<>(StatusUpdate.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, StatusUpdate> kafkaListenerStatusUpdateContainerFactory() 
	{
		ConcurrentKafkaListenerContainerFactory<String, StatusUpdate> factory=new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryStatusUpdate());
		
		return factory;
	}
	
}


























