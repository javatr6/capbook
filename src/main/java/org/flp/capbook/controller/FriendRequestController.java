package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.dao.IFriendRequestDao;
import org.flp.capbook.model.Friend_request;
import org.flp.capbook.service.FriendRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FriendRequestController {
	
	@Autowired
	private FriendRequestServiceImpl requestService;
	
	
	@GetMapping("/request/{id}")
	public ResponseEntity<List<Friend_request>>getUsers(@PathVariable("id")Integer id){

		List<Friend_request>users=requestService.getUsers(id);
		if(users.isEmpty())

			return new ResponseEntity("Sorry! User not available",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Friend_request>>(users, HttpStatus.OK);

	}
	@PutMapping("/request/{request}/{userId}")
	public ResponseEntity<List<Friend_request>>updateStatus(@PathVariable("request") String request,@PathVariable("userId")Integer userId){

		String status=request.substring(request.length()-6, request.length());
		String uName=request.substring(0,request.length()-6);
		
		List<Friend_request>users=requestService.updateStatus(uName,status,userId);
		if(users.isEmpty())
			return new ResponseEntity("Sorry! User not available",HttpStatus.NOT_FOUND);
	
		return new ResponseEntity<List<Friend_request>>(users, HttpStatus.OK);

	}
}
