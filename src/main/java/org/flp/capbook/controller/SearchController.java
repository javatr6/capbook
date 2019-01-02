package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.model.Groups;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private ISearchService searchService;
	
	
	
	@GetMapping("/names")
	public ResponseEntity<List<Groups>> getAllGroupNames(){
		
		List<Groups> names= searchService.getAllGroupNames();
		if(names.isEmpty())
			return new ResponseEntity(
					"Sorry! Group info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Groups>>(names, HttpStatus.OK);
	}
	
	@GetMapping("/unames")
	public ResponseEntity<List<UserProfile>> getAllUserNames(){
		
		List<UserProfile> unames= searchService.getAllUserNames();
		if(unames.isEmpty())
			return new ResponseEntity(
					"Sorry! User info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<UserProfile>>(unames, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/names/{letter}")
	public ResponseEntity<List<String>> getGroupNames(@PathVariable("letter") String letter){
		System.out.println(letter);
		List<String> names= searchService.getGroupNames(letter);
		if(names.isEmpty())
			return new ResponseEntity(
					"Sorry! Group info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<String>>(names, HttpStatus.OK);
	}
	
	@GetMapping("/unames/{username}")
	public ResponseEntity<List<String>> getUserNames(@PathVariable("username") String username){
		System.out.println(username);
		List<String> names= searchService.getUserName(username);
		if(names.isEmpty())
			return new ResponseEntity(
					"Sorry! User info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<String>>(names, HttpStatus.OK);
	}
	
	
	

}
