package com.awon.demo.personapi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
	
	Person findByMobileNo(String mobileNo);
}
