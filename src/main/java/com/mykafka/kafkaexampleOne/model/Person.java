package com.mykafka.kafkaexampleOne.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class Person {

	private String name;
	private String surname;
	private String sex;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime timeOfPerson;

	public Person() {
	}

	public Person(String name, String surname, String sex) {
		this.name = name;
		this.surname = surname;
		this.sex = sex;
//		this.timeOfPerson = LocalDateTime.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public LocalDateTime getTimeOfPerson() {
		return timeOfPerson;
	}

	public void setTimeOfPerson(LocalDateTime timeOfPerson) {
		this.timeOfPerson = timeOfPerson;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", sex='" + sex + '\'' +
				", timeOfPerson=" + timeOfPerson.toString() +
				'}';
	}

}

