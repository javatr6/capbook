package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.model.ChangePassword;
import org.flp.capbook.model.Login;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.ICapBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profileCreation")
@CrossOrigin("*")
public class ProfileController {

	@Autowired
	private ICapBookService friendservice;
	
	
	
	@PostMapping(value="/profile")
	ResponseEntity<List<UserProfile>> saveProfile(@RequestBody UserProfile profile){
		List<UserProfile> prfl= friendservice.saveUser(profile); 
		if(prfl.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<UserProfile>>(prfl, HttpStatus.OK);
	}
	@GetMapping(value="/profile")
	ResponseEntity<List<UserProfile>> getProfile(){
		List<UserProfile> prfl= friendservice.getUserDetails();
		if(prfl.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<UserProfile>>(prfl, HttpStatus.OK);
	}
	@PostMapping(value="/login")
	ResponseEntity<List<Login>> saveLogin(@RequestBody Login login){
		List<Login> lg= friendservice.savelogin(login);
		if(lg.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<Login>>(lg, HttpStatus.OK);
	}
	@GetMapping(value="/login")
	ResponseEntity<List<Login>> getLogin(){
		List<Login> lg= friendservice.getLoginDetails();
		if(lg.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<Login>>(lg, HttpStatus.OK);
	}
	
	@PostMapping(value="/changepwd/{userId}/{newPasswd}/{oldPasswd}")
	ResponseEntity<ChangePassword> saveLogin(@PathVariable("newPasswd") String nPasswd,@PathVariable("userId") Integer userid,@PathVariable("oldPasswd") String oPasswd){
		Integer uid=userid;
		String mail=friendservice.getMail(userid);
		System.out.println(mail);
		String Paswd=friendservice.getPsswdBymail(mail);
		System.out.println("Password from db"+Paswd);
		System.out.println("Old Password from angu"+oPasswd);
		System.out.println("New Password from angu"+nPasswd);
		if(Paswd.equals(oPasswd)) {
			
			//friendservice.saveNewPasswd(mail,Paswd, nPasswd);
			friendservice.saveLgnPasswd(nPasswd,mail);
			return new ResponseEntity("Hurray! your old password is same as new", 
					HttpStatus.NOT_FOUND); 
		
		}
		return new ResponseEntity("sorry! your old password is Differs from  new password try again", 
				HttpStatus.NOT_FOUND); 
		
	}
	/*@PostMapping(value="/changepwd")
	ResponseEntity<List<ChangePassword>> savePasswd(@RequestBody ChangePassword chngepsswd){
		List<ChangePassword> psswd= friendservice.savepsswrd(chngepsswd);
		if(psswd.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<ChangePassword>>(psswd, HttpStatus.OK);
	}
	*/
	/*@GetMapping(value="/changepwd")
	ResponseEntity<List<ChangePassword>> getPassword(){
		List<ChangePassword> lg= friendservice.getPsswrdDetails();
		if(lg.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<ChangePassword>>(lg, HttpStatus.OK);
	}*/
	@GetMapping(value="/EmailNPwd/{email}/{password}")
	ResponseEntity<Login> getEmailAndPwd(@PathVariable("email") String email,@PathVariable("password") String password){
		Login lg= friendservice.findByUsername(email);
		if(lg==null)
		{
			return new ResponseEntity("Sorry! unable to add friends", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<Login>(lg, HttpStatus.OK);
	}
	
	
	
}

