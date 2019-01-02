package org.flp.capbook.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.apache.tomcat.util.codec.binary.Base64;
import org.flp.capbook.model.Email;
import org.flp.capbook.service.ICapBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forgetPwd")
@CrossOrigin("*")
public class PasswordController {
	@Autowired
	private ICapBookService friendservice;
	private Base64 base64 = new Base64();

	@PostMapping(value="/passwd/{email}")
		 ResponseEntity getPassword(@PathVariable("email") String mail){
		 String mailId=mail;
		 Email email=new Email();
		 
			String password= friendservice.getPassword(mail);
			String decodedString = new String(base64.decode(password.getBytes()));
            System.out.println(decodedString);
			if(decodedString.isEmpty())
			{
				return new ResponseEntity("Sorry! unable to get password", 
						HttpStatus.NOT_FOUND); 
			}
			else {
				email.setToAddress(mailId);
				email.setMessageBody(decodedString);
				email.setDate(Date.valueOf(LocalDate.now()));
				email.setFromAddress("capbook@gmail.com");
				email.setSubject("Forget Password");
				friendservice.saveEmaildetails(email);
				return new ResponseEntity(decodedString, HttpStatus.OK);
			}
			
	         
			
		}
	
	
	
	
	
}
