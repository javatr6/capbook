package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IFriendRequestDao;
import org.flp.capbook.dao.IUserDao;
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

}
