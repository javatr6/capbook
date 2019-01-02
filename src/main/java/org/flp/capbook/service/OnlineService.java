package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IOnlineDao;
import org.flp.capbook.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("onlineService")
public class OnlineService implements IOnlineService{
	@Autowired
	private IOnlineDao onlineDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<Integer> getAllUserMails1(Integer userId) {
		
		return onlineDao.getAllUserMails1(userId);
	}
	@Override
	public List<Integer> getAllUserMails2(Integer userId) {
		
		return onlineDao.getAllUserMails2(userId);
	}
	
	@Override
	public List<String> getAllUserNames(List<Integer> ids) {
		List<String> email=userDao.getEmail(ids);
		System.out.println(email);
		return onlineDao.getAllUserNames(email);
	}
}