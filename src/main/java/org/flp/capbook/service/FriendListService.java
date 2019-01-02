package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IFriendListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FriendListService")
public class FriendListService implements IFriendListService{
	
	
	@Autowired
	private  IFriendListDao friendlistdao;


	@Override
	public List<String> getAllFriendList(Integer receiverId) {
		// TODO Auto-generated method stub
		return friendlistdao.getAllFriendList(receiverId);
	}

	/*@Override
	public List<String> getAllFriendrequest2(Integer senderId) {
		// TODO Auto-generated method stub
		return friendrequestdao.getAllFriendrequest1(senderId);
	}
*/
	

	
}
