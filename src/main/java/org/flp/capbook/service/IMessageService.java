package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Message;;



public interface IMessageService {
	
	 List<Long> getAllFriendRequest1(Integer userId);
	 
	   List<Long> getAllFriendrequest2(Integer userId);
	   
	   Long getUserMobileNum( Integer userId);
	   
	   void sendMsg(Message message);
	   
	   List<Message> getAllMessages(Long mobileNum);
	   
	   String getUserName1(Integer userId);

}
