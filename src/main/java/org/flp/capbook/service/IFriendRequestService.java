package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Email;
import org.flp.capbook.model.Friend_request;


public interface IFriendRequestService {
	public List<Friend_request> updateStatus(Friend_request request);
	
	List<String> getAllFriendRequest1(Integer userId);
	   List<String> getAllFriendrequest2(Integer userId);
	   void sendEmail(Email email);
	   String getUserEmail(Integer userId);
	   
	   public String findEmail(String emailid);

}
