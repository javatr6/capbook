package org.flp.capbook.controller;

import org.flp.capbook.model.Login;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.ICapBookService;
import org.flp.capbook.service.ILoginService;
import org.flp.capbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private ICapBookService friendservice;
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<UserProfile> checkLogin( @PathVariable("email") String email,@PathVariable("password") String password){
	Login login=  friendservice.findByUsername(email);
      System.out.println(login);
		if(loginService.checkUser(login)) {
			UserProfile users= userService.getUserDetails(login.getEmail());
			System.out.println(users);
			if(users==null)
				return new ResponseEntity("Error Fetching User Details",HttpStatus.NOT_FOUND);
			return new ResponseEntity<UserProfile>(users, HttpStatus.OK);
		}
		return new ResponseEntity("Invalid Credentials",HttpStatus.NOT_FOUND);
	} 
 

}
