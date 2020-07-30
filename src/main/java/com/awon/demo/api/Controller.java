package com.awon.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/public")
public class Controller {
	@Autowired
	private PersonService personService;
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/person")
	public ResponseEntity<?> getPerson() {
		try {
			return ResponseEntity.ok(personService.findAll());
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage());
		}
	}
	
	@PostMapping("/person")
	public ResponseEntity<?> saveDevice(@RequestBody PersonDTO dto) {
		try {			
			return ResponseEntity.ok(personService.savePerson(dto));
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage());
		}
	}
	
	@GetMapping("/role")
	public ResponseEntity<?> getRole() {
		try {
			return ResponseEntity.ok(roleService.findAll());
		} catch (Exception e) {
			throw new ApiRequestException(e.getMessage());
		}
	}
}
