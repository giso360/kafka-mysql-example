package com.mykafka.kafkaexampleOne.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Personas {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "sex")
	private String sex;

	@Column(name = "age")
	private String age;

	public Personas() {
	}

	public Personas(int id, String name, String surname, String sex, String age) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.age = age;
	}

	public Personas(String name, String surname, String sex) {
		this.name = name;
		this.surname = surname;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personas{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", sex='" + sex + '\'' +
				", age='" + age + '\'' +
				'}';
	}

}

