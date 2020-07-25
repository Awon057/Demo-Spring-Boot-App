package com.awon.demo.api;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter @Setter @NoArgsConstructor
public class Person implements Serializable{

	private static final long serialVersionUID = 8191639937744519757L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name= "person_name")
	private String personName;
	
	@Column(name= "age")
	private int age;
	
	@Column(name= "height")
	private Double height;

	@Column(name= "weight")
	private Double weight;
	
	@Column(name= "phone_no", unique = true)
	private String mobileNo;

	@CreationTimestamp
	@Column(name= "created_at")
	private Date createdAt;
}
