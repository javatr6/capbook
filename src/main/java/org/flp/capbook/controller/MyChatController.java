package org.flp.capbook.controller;
import java.util.ArrayList;
import java.util.List;

import org.flp.capbook.model.Chat;

import org.flp.capbook.model.MessageT;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.IChatService;
import org.flp.capbook.service.IMsgService;
import org.flp.capbook.service.IUserService;
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
@CrossOrigin("*")
@RequestMapping("/api")

public class MyChatController {
	@Autowired
	private IChatService chatService;
	@Autowired
	private IMsgService msgService;
	@Autowired
	private IUserService userService;

	@PostMapping("/chat")
	private ResponseEntity<List<Chat>> saveChat(@RequestBody Chat chat){
		List<Chat> chats=chatService.saveChat(chat);
		if(chats.isEmpty()) {
			return new ResponseEntity("Sorry",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Chat>>(chats,HttpStatus.OK);
	}
	@GetMapping("/chat")
	private ResponseEntity<List<Chat>> getAllChats(){
		List<Chat> chats=chatService.getAllChats();
		if(chats.isEmpty()) {
			return new ResponseEntity("Sorry",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Chat>>(chats,HttpStatus.OK);
	}
	@PostMapping("/messages")
	private ResponseEntity<List<MessageT>> saveMessage(@RequestBody MessageT message){
		List<MessageT> messages=msgService.saveMessage(message);
		if(messages.isEmpty()) 
			return new ResponseEntity("Sorryy",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<MessageT>>(messages,HttpStatus.OK);
	}
	@GetMapping("/messages")
	private ResponseEntity<List<MessageT>> getAllMessages(){
		List<MessageT> messages=msgService.getAllMessages();
		if(messages.isEmpty())
			return new ResponseEntity("Sorry",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<MessageT>>(messages,HttpStatus.OK);
	}
	@GetMapping("/chat/chats/{s_id}/{r_id}")
	private ResponseEntity<List<MessageT>> getChats(@PathVariable("s_id") Integer user_id,@PathVariable("r_id") Integer rec_id){
		System.out.println("hsdfk");
		List<Chat> chats=chatService.getChatMessage(user_id,rec_id);
		List<MessageT>messages = new ArrayList<>(); 
		if(chats.isEmpty()) {

			return new ResponseEntity("Sorry",HttpStatus.NOT_FOUND);
		}else {
			for(Chat m:chats) {
				messages=m.getMessages();
				for(MessageT m1:messages) {
					System.out.println(m1.getText());
				}	
			}
			return new ResponseEntity<List<MessageT>>(messages,HttpStatus.OK);
		}
	}
	@SuppressWarnings("null")
	@PostMapping("/chat/{s_id}/{r_id}")
	private ResponseEntity<List<Chat>> saveChats(@PathVariable("s_id") Integer user_id,@PathVariable("r_id") Integer user_receiver_id,@RequestBody MessageT message){
		
		UserProfile user=new UserProfile();
		user.setUserId(user_id);
		Chat chat=new Chat();
		chat.setUser(user);
		chat.setUser_Receiver_Id(user_receiver_id);
		Chat existChat=chatService.verifyingChat(chat);
		List<Chat> chats=null;
		
		if(existChat!=null) {
			List<MessageT> allMessages=existChat.getMessages();
			allMessages.add(message);
			existChat.setMessages(allMessages);
			System.out.println(message.getText());
			 chats=chatService.saveChat(existChat);
		}else {
			System.out.println("Sorry Ur method is not called");
			List<MessageT> newMsg=new ArrayList<MessageT>();
;			newMsg.add(message);
			chat.setMessages(newMsg);
			System.out.println("fdsf");
			
			chats=chatService.saveChat(chat);
		}
		
		if(chats.isEmpty()) {
			return new ResponseEntity("Sorry",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Chat>>(chats,HttpStatus.OK);
	}

}
