package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IEmailDao;
import org.flp.capbook.dao.IFriendRequestDao;
import org.flp.capbook.dao.IUserDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.Email;
import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("friendrequestService")
public class FriendRequestServiceImpl implements IFriendRequestService{
	
	
	@Autowired
	private IFriendRequestDao requestDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IUserProfileDao  userprofiledao;
	
	@Autowired
	private IEmailDao emailDao;

	public List<Friend_request> updateStatus(Friend_request request) {
		requestDao.save(request);
		return requestDao.findAll();
	}

	public List<Friend_request> updateStatus(String uName, String status,Integer userSession) {
		
		UserProfile users=userDao.findByName(uName);
		
		Friend_request request = requestDao.getFriend(users.getUserId(),userSession);
		
		request.setStatus(status);
		
		requestDao.save(request);
		
		return requestDao.findAll();
	}

	public List<Friend_request> getUsers(Integer id) {
		// TODO Auto-generated method stub
		return requestDao.getUsers(id);
	}
	
	
	

	@Override
	public String getUserEmail(Integer userId) {
		
		return userprofiledao.getUserEmail(userId);
	}

	@Override
	public String findEmail(String emailid) {
		// TODO Auto-generated method stub
		
		return userprofiledao.findEmail(emailid);
		
	}

	@Override
	public List<String> getAllFriendRequest1(Integer receiverId) {
		List<Integer> userIds = requestDao.getAllFriendrequest1(receiverId);
		System.out.println(userIds);
		
		if(!userIds.isEmpty()){
			return userprofiledao.getEmail(userIds);
		}
		
		return null;
	}

	@Override
	public List<String> getAllFriendrequest2(Integer senderId) {
		List<Integer> userIds = requestDao.getAllFriendrequest2(senderId);
		System.out.println(userIds);
		if(!userIds.isEmpty()){
			return userprofiledao.getEmail(userIds);
		}
		
		return null;
	}

	@Override
	public void sendEmail(Email email) {
		emailDao.save(email);
		
	}

	

}
