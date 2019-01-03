package org.flp.capbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.OnlineService;
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
public class OnlineController {

	
	@Autowired
	private OnlineService onlineService;
	/**
	 * returns all the friends of the user who are online at that point of time
	 * @param userId
	 * @return List<String> of userNames
	 */
	@GetMapping("/online/{userId}")
	public ResponseEntity<List<UserProfile>> getAllUser(@PathVariable("userId") Integer userId){
		
		List<Integer> request=onlineService.getAllUserMails1(userId);
		
		List<Integer> request1=onlineService.getAllUserMails2(userId);
		
		if(request==null)
			request=new ArrayList<>();
		for(Integer user:request1) {
			request.add(user);
		}
		
		List<UserProfile> userNames=onlineService.getAllUserNames(request);
		System.out.println(userNames);
		
		return new ResponseEntity<List<UserProfile>>(userNames, HttpStatus.OK);
		//return null;
	}
	
	
	


}
 
 
