package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.IFriendService;
import org.flp.capbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FriendController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private IFriendService friendService;
	 
	@GetMapping("/friend/input")
	public ResponseEntity<List<UserProfile>> searchFriend(@Param("input") String input) {
		
		List<UserProfile> users = userService.searchFriend(input);
		
		if(users.isEmpty()) {
			return new ResponseEntity("Sorry no users found",HttpStatus.OK);
		}
		return new ResponseEntity<List<UserProfile>>(users,HttpStatus.OK);
		
	}
	
	@PostMapping("/request")
	public ResponseEntity<List<Friend_request>> addFriend(@RequestBody Friend_request friend){
		List<Friend_request> friend1 = friendService.addFriend(friend);
		System.out.println(friend1);
		if(friend1.isEmpty()) {
			return new ResponseEntity("sorry no users found",HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Friend_request>>(friend1,HttpStatus.OK);
	}
	

	
	
}
