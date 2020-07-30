package com.awon.demo.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PersonDTO extends Status {

	private String personName;
	private int age;
	private Double height;
	private Double weight;
	private String mobileNo;
	private long roleID;
}
