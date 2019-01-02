package org.flp.capbook.controller;

import java.sql.Date;
import java.util.List;

import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.IBirthdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BirthdayController {
	
@Autowired
private IBirthdayService birthdayservice;


// This method is to get the usernames of the user in session and if he is the receiver of friend request
	@GetMapping("/birthdatesrec/{recid}")
	public ResponseEntity<List<String>> getDetails(@PathVariable("recid")Integer recid){
		List<String> birthday= birthdayservice.getDetails(recid);
	/*	List<String> birthday1= birthdayservice.getUsername(recid);*/
		System.out.println(birthday);
		/*System.out.println(birthday1);*/
		
		return new ResponseEntity<List<String>>(birthday, HttpStatus.OK);
	}
// This method is to get the usernames of the user in session and if he is the sender of friend request

	@GetMapping("/birthdatessen/{recid}")
	public ResponseEntity<List<String>> getDetails1(@PathVariable("recid")Integer recid){
		List<String> birthday1= birthdayservice.getDetails1(recid);
	/*	List<String> birthday1= birthdayservice.getUsername(recid);*/
		System.out.println(birthday1);
		/*System.out.println(birthday1);*/
		
		return new ResponseEntity<List<String>>(birthday1, HttpStatus.OK);
	}
	/*
	@GetMapping("/usernames/{recid}")
	public ResponseEntity<List<String>> getUsername(@PathVariable("recid")Integer recid){
		List<String> birthday= birthdayservice.getUsername(recid);
		System.out.println(birthday);
		
		return new ResponseEntity<List<String>>(birthday, HttpStatus.OK);
	}*/
}

