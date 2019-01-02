package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.service.FriendListService;
import org.flp.capbook.service.IFriendListService;
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
public class FriendListController {
	
	@Autowired
	private IFriendListService FriendListService;
	
	
	@GetMapping("/list/{userId}")
	private ResponseEntity<List<String>> getFriendList(@PathVariable("userId") Integer userId){
		List<String> request=FriendListService.getAllFriendList(userId);
		System.out.println(request);
		
		return new ResponseEntity<List<String>>(request, HttpStatus.OK);
	}
	
	/*@GetMapping("/requests/{userId1}")
	private ResponseEntity<List<String>> getFriendrequest2(@PathVariable("userId1") Integer userId1){
		List<String> request=FriendRequestService.getAllFriendrequest2(userId1);
		
		return new ResponseEntity<List<String>>(request, HttpStatus.OK);
	}*/
	
	


}











