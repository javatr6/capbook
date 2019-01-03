package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IReferDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ReferService")
public class ReferService implements IReferService{
	
	
	@Autowired
	private  IReferDao referdao;
	
	@Autowired
	private IUserProfileDao userprofiledao;

	@Override
	public List<String> getAllFriendRequest1(Integer receiverId) {
		List<String> frndList= referdao.getAllFriendrequest1(receiverId);
		String userName = userprofiledao.getUserName(receiverId);
		frndList.remove(userName);
		return frndList;
	}

	
	

	
}
