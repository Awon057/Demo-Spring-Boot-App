package com.awon.demo.personapi;

import java.io.IOException;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.awon.demo.imageapi.ImageService;


@RestController
@RequestMapping("/api/v1/public")
public class Controller {
	@Autowired
	private PersonService personService;
	@Autowired
	private ImageService imageService;
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
	
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile[] files) {
		String returnVal = "Success";
		for (MultipartFile imageFile : files) {
			try {
				imageService.saveImage(imageFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				returnVal="Failed";
			}
		}
		return returnVal;
	}
}
