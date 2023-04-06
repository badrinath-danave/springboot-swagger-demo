package com.swagger.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.springboot.model.Contact;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class AddressBookResource {

	ConcurrentHashMap<String, Contact> contacts = new ConcurrentHashMap<>();
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="Finds Contacts by id",
			notes="Provide an id to lookup specific contact from the address book",
			response=Contact.class)
	public Contact getContact(@PathVariable String id) {
		
		return contacts.get(id);
	}
	
	@GetMapping("/")
	public List<Contact> getAllContacts(){
		
		return new ArrayList<Contact>(contacts.values());
	}
	
	@PostMapping("/")
	public Contact addContact(@RequestBody Contact contact) {
		
		return contacts.put(contact.getId(), contact);
	}
}
