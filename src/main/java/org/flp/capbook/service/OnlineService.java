package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IOnlineDao;
import org.flp.capbook.dao.IUserDao;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("onlineService")
public class OnlineService implements IOnlineService{
	@Autowired
	private IOnlineDao onlineDao;
	
	@Autowired
	private IUserDao userDao;
	/**
	 * returns all the user ids by the sender ids
	 */
	@Override
	public List<Integer> getAllUserMails1(Integer userId) {
		
		return onlineDao.getAllUserMails1(userId);
	}
	/**
	 * returns all the user ids by the receiver ids
	 */
	@Override
	public List<Integer> getAllUserMails2(Integer userId) {
		
		return onlineDao.getAllUserMails2(userId);
	}
	/**
	 * sends all the user id list to the userDao and gets user mails from the user profile table
	 * those list of mails are passed to getAllUserNames method and returns the user names.
	 */
	@Override
	public List<UserProfile> getAllUserNames(List<Integer> ids) {
		List<String> email=userDao.getEmail(ids);
		System.out.println(email);
		List<Integer> userIds=onlineDao.getAllUserIds(email);
		System.out.println(userIds);
		return userDao.getAllUserNames(userIds); 
 

	}
}