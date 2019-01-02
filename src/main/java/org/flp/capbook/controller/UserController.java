package org.flp.capbook.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.flp.capbook.model.Email;
import org.flp.capbook.model.Message;
import org.flp.capbook.model.Login;
import org.flp.capbook.model.Status;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.ICapBookService;
import org.flp.capbook.service.IEmailService;
import org.flp.capbook.service.IFriendRequestService;
import org.flp.capbook.service.ILoginService;
import org.flp.capbook.service.IMessageService;
import org.flp.capbook.service.IUserService;
import org.flp.capbook.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@Autowired
	private StorageService profileService;
	
	@Autowired
	private IFriendRequestService friendRequestService;
	
	@Autowired 
	private IMessageService mobileService;
	
	@Autowired
	private IEmailService emailService;
	
	
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
	
	@PostMapping("/saveStatus/{userId}")
	public ResponseEntity<String> handleFileUpload(@RequestBody Status status,@PathVariable("userId") Integer userId) {
		String message = "Uploaded successfully";
		System.out.println("im in controller"+userId);
		
		System.out.println();
			profileService.store(status,userId);
		
			sendSms(userId);
			sendEmails(userId);
		
			return ResponseEntity.status(HttpStatus.OK).body(message);
	
	}
	
	
	//Sending Sms Notifications
	void sendSms(Integer userId) {
		
		List<Long> request=mobileService.getAllFriendRequest1(userId);;
		List<Long> request1=mobileService.getAllFriendrequest2(userId);
		String userName = mobileService.getUserName1(userId);

		//System.out.println(request);
		//System.out.println(request1);

		if(request==null) {
			request=new ArrayList<>();
		}
		for(Long user:request1) {
			request.add(user);
		}

		for(Long mobile:request) {
			Message msg=new Message();
			msg.setReceivedDate(Date.valueOf(LocalDate.now()));
			msg.setUserName(userName);
			msg.setMobileNumber(mobile);

			msg.setMsgBody("hii your friend posted one post");
			mobileService.sendMsg(msg);


		}
		
	}
	
	//sending email
	void sendEmails(Integer userId) {
		
	List<String> request=friendRequestService.getAllFriendRequest1(userId);;
	List<String> request1=friendRequestService.getAllFriendrequest2(userId);

	//System.out.println(request);
	//System.out.println(request1);

	if(request==null) {
		request=new ArrayList<>();
	}

	if(request1==null) {
		request1=new ArrayList<>();
	}else {

		for(String user:request1) {
			request.add(user);
		}
	}

	System.out.println(request);
	for(String femail:request) {
		Email email=new Email();
		email.setDate(Date.valueOf(LocalDate.now()));
		email.setFromAddress(friendRequestService.getUserEmail(userId));
		email.setToAddress(femail);
		email.setSubject("post notification");
		email.setMessageBody("hii your friend posted one post");
		friendRequestService.sendEmail(email);

	}
	}
		
	
	@GetMapping("/getStatus/{userId}")
	public ResponseEntity<List<Status>> getStatus(@PathVariable("userId")Integer userId){
		
		List<Status> status = profileService.getStatus(userId);
		
		//return ResponseEntity.status(HttpStatus.OK).body(status);
		return new ResponseEntity<List<Status>>(status, HttpStatus.OK); 
		
	}
	
	@GetMapping("/request/{email}/{userId}")
	public ResponseEntity <String> findEmail(
			@PathVariable("email")String emailid,@PathVariable("userId") Integer userId){
		System.out.println(emailid);
		String  email= friendRequestService.findEmail(emailid);
		if(email==null) {
			Email email1=new Email();
			email1.setDate(Date.valueOf(LocalDate.now()));
			email1.setFromAddress(friendRequestService.getUserEmail(userId));
			email1.setToAddress(emailid);
			email1.setSubject("Invitation to CapBook");
			email1.setMessageBody("google.co.in");
			friendRequestService.sendEmail(email1);
			return new ResponseEntity("Message sent successfully", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity("User already exists", HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStatus/{status_id}")
	public ResponseEntity <String> deleteStatus(@PathVariable("status_id") Integer status_id){
		System.out.println(status_id);
		if(profileService.deleteStatus(status_id)) {
			return new ResponseEntity("Deleted successfully", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(" failed to Delete", HttpStatus.NOT_FOUND);
	}
			
	@GetMapping("/getEmails/{userId}")
	public ResponseEntity<List<Email>> getAllEmailsUser(
			@PathVariable("userId") Integer userId){
		String email=emailService.getUserEmail(userId);

		List<Email> emails= emailService.getAllEmailsOfUser(email);
		if(emails.isEmpty())
		{
			return new ResponseEntity("Sorry! No Messages available!", 
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Email>>(emails, HttpStatus.OK);

	} 
	@GetMapping("/getMsgs/{userId}")
	public ResponseEntity<List<Message>> getAllMsgsUser(
			@PathVariable("userId") Integer userId){
		Long mobileNum=mobileService.getUserMobileNum(userId);

		List<Message> messages= mobileService.getAllMessages(mobileNum);
		if(messages.isEmpty())
		{
			return new ResponseEntity("Sorry! No Messages available!", 
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);

	} 

}
