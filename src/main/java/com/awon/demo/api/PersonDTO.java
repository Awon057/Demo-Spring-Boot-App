package com.awon.demo.api;

import java.util.Date;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PersonDTO {

	private String personName;
	private int age;
	private Double height;
	private Double weight;
//	private Date createdAt;
}
