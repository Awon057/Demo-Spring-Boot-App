package com.awon.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends CommonService<Person> {

	@Autowired
	private PersonRepository repository;
	
	public PersonService(JpaRepository<Person, Long> repository) {
		super(repository);
		this.repository = (PersonRepository)repository;
	}
	
	public void savePerson(PersonDTO dto) {
		Person person = new Person();
		person.setPersonName(dto.getPersonName());
		person.setAge(dto.getAge());
		person.setWeight(dto.getWeight());
		person.setHeight(dto.getHeight());
		
		repository.save(person);
	}
}
