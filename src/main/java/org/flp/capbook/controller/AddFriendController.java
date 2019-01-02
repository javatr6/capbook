package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.model.Friend_request;
import org.flp.capbook.service.ICapBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/frnd")
@CrossOrigin("*")
public class AddFriendController {
	
	//private String label="AddFriend";

	@Autowired
	private ICapBookService friendservice;
	
	@RequestMapping(value="/addFriend",method=RequestMethod.GET)
	ResponseEntity<Friend_request> addFriend(@RequestParam("receiverId") String toUserId) {
				return null;	
}
	
	@PostMapping(value="/friend")
	ResponseEntity<List<Friend_request>> saveFriend(@RequestBody Friend_request friend){
		List<Friend_request> friend1= friendservice.saveFriend(friend);
		if(friend1.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends",HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<Friend_request>>(friend1, HttpStatus.OK);
	}
	@GetMapping(value="/friend")
	ResponseEntity<List<Friend_request>> getFriend(){
		List<Friend_request> friend1= friendservice.getFriend();
		if(friend1.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Friend_request>>( friend1, HttpStatus.OK);
	}
}