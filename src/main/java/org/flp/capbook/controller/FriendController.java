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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<Friend_request> addFriend(@RequestBody Friend_request friend){
		Friend_request friend1 = friendService.addFriend(friend);
		if(friend1==null) {
			return new ResponseEntity("sorry no users found",HttpStatus.OK);
		}
		
		return new ResponseEntity<Friend_request>(friend1,HttpStatus.OK);
	}
	
	@DeleteMapping("/request/{requestId}")
	public ResponseEntity<Friend_request> deleteFriend(@PathVariable("requestId") Integer requestId){
		Friend_request friend = friendService.deleteRequest(requestId);
		/*if(friend==null) {
			return new ResponseEntity<Friend>(friend,HttpStatus.NOT_FOUND);
		}*/
		return new ResponseEntity("successfully deleted",HttpStatus.OK);
	
	} 
 


	
	
}
