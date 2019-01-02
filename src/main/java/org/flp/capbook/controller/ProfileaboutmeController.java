package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.model.Groups;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.ProfileaboutmeImpl;
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
public class ProfileaboutmeController {
	
	@Autowired
	private ProfileaboutmeImpl profileaboutmeService;
	
	@GetMapping("/aboutme/{userId}")
	public ResponseEntity<UserProfile> getAllDetails(@PathVariable("userId") Integer userId){
		
		UserProfile user=profileaboutmeService.getAllDetails(userId);
		if(user==null) {
			new ResponseEntity("No Groups available",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserProfile>(user,HttpStatus.OK);

}
}
