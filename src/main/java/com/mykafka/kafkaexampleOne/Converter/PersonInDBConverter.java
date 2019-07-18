package com.mykafka.kafkaexampleOne.Converter;

import com.mykafka.kafkaexampleOne.entities.Personas;
import com.mykafka.kafkaexampleOne.exception.KafkaExampleException;
import com.mykafka.kafkaexampleOne.model.Person;
import com.mykafka.kafkaexampleOne.util.RandomAge;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonInDBConverter implements Converter<Person, Personas> {


//	private Ages ages;
//
//	@Autowired
//	public PersonInDBConverter(Ages ages) {
//		this.ages = ages;
//	}

	@Override

	public Personas convert(Person input) throws KafkaExampleException {
		Personas personas = new Personas(input.getName(), input.getSurname(), input.getSex());
		personas.setAge(RandomAge.getAge()+"");
		return personas;
	}

}
