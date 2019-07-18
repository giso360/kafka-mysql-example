package com.mykafka.kafkaexampleOne.service;

import com.mykafka.kafkaexampleOne.Converter.PersonInDBConverter;
import com.mykafka.kafkaexampleOne.model.Person;
import com.mykafka.kafkaexampleOne.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KafkaExampleService {

	private PersonasRepository personasRepository;

	private PersonInDBConverter converter;

	@Autowired
	public KafkaExampleService(PersonasRepository personasRepository, PersonInDBConverter converter) {
		this.personasRepository = personasRepository;
		this.converter = converter;
	}

	public void storePerson (Person person){
		personasRepository.save(converter.convert(person));
	}

	public int getAllPeople (){
		return personasRepository.findAll().size();
	}

}
