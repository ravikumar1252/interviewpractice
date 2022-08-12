package com.person.job;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="per")
public class PersonPojo implements Serializable  {
	
	private static final long serialVersionUID=1L;
	private Integer id;
	private String name;
	/*public PersonPojo(Integer id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}*/
	private Integer age;
	private String address;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	

}
