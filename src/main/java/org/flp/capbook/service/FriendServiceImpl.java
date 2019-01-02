package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IFriendDao;
import org.flp.capbook.model.Friend_request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service("friendService")
public class FriendServiceImpl implements IFriendService{

	@Autowired
	IFriendDao friendDao;

	@Override
	public List<Friend_request> addFriend(Friend_request friend) {
		System.out.println("friend service");
		friendDao.save(friend);
		
		return friendDao.findAll();
	}
	
	

	

}
