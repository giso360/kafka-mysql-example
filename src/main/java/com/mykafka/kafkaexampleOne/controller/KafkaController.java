package com.mykafka.kafkaexampleOne.controller;

import com.mykafka.kafkaexampleOne.model.Person;
import com.mykafka.kafkaexampleOne.service.KafkaExampleService;
import kafka.zookeeper.ZooKeeperClient;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.zookeeper.ZKUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping(path = "/kafka-api")
@EnableKafka /*Consumer Annotation*/
public class KafkaController {

	private final Logger logger = LoggerFactory.getLogger(KafkaController.class);

	private KafkaTemplate<String, Person> kafkaTemplate;

	private KafkaExampleService kafkaExampleService;

	@Qualifier
	private Map<String, Object> consumerConfigProperties;

	@Autowired
	public KafkaController(KafkaTemplate<String, Person> kafkaTemplate,
						   KafkaExampleService kafkaExampleService, Map<String, Object> consumerConfigProperties) {
		this.kafkaTemplate = kafkaTemplate;
		this.kafkaExampleService = kafkaExampleService;
		this.consumerConfigProperties = consumerConfigProperties;
	}

	//Producer Code
	@PostMapping("/producer-data")
	public void postToKafka(@RequestBody Person person){
		person.setTimeOfPerson(LocalDateTime.now());
		kafkaTemplate.send("topicOne", person);
		logger.info("[Person Forwarded to Kafka Queue]\t" + person.toString());
	}

	//Consumer Code
	@KafkaListener(topics = "topicOne")
	public void getFromKafka(Person person){

		logger.info(person.toString());
		System.out.println(person.toString());
		//My Code From Here On
//		if (syncedOrNot() == false){
//
//		}

		kafkaExampleService.storePerson(person);
	}

	private boolean syncedOrNot(){
		KafkaConsumer<String, Person> consumer = new KafkaConsumer<>(consumerConfigProperties);
		consumer.seekToEnd(consumer.assignment());
		int queue_len = (int)consumer.position(consumer.assignment().iterator().next());
		return queue_len == kafkaExampleService.getAllPeople() + 1;
	}

	private void synchronize(){

	}

}
