package com.mykafka.kafkaexampleOne.configuration;

import com.mykafka.kafkaexampleOne.model.Person;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka /*Consumer Code Only*/
public class KafkaConfiguration {

	//START: PRODUCER CONFIGURATION

	@Bean
	public Map<String, Object> producerConfigProperties(){
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return config;
	}

	@Bean
	public ProducerFactory<String, Person> producerFactory() {

		return new DefaultKafkaProducerFactory<>(producerConfigProperties());
	}

	@Bean
	public KafkaTemplate<String, Person> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	//END: PRODUCER CONFIGURATION


	//======================================================================================================//
	//======================================================================================================//
	//======================================================================================================//
	//======================================================================================================//
	//======================================================================================================//


	//START: CONSUMER CONFIGURATION

	@Bean
	public Map<String, Object> consumerConfigProperties(){
		Map<String, Object> config = new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "groupOne");
		return config;
	}

	@Bean
	public ConsumerFactory<String, Person> consumerFactory() {

		return new DefaultKafkaConsumerFactory<>(consumerConfigProperties(), new StringDeserializer(), new JsonDeserializer<>(Person.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Person> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Person> concurrentKafkaListenerContainerFactory =
				new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());
		return concurrentKafkaListenerContainerFactory;
	}
	//END: CONSUMER CONFIGURATION

}
