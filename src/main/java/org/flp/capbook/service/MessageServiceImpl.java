package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IEmailDao;
import org.flp.capbook.dao.IFriendRequestDao;
import org.flp.capbook.dao.IMessageDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mobileService")
public class MessageServiceImpl implements IMessageService{
	
	@Autowired
	private  IFriendRequestDao friendrequestdao;
	
	@Autowired
	private IUserProfileDao userprofiledao;
	@Autowired
	private IMessageDao messageDao;
	
	

	@Override
	public List<Long> getAllFriendRequest1(Integer receiverId) {
		List<Integer> userIds = friendrequestdao.getAllFriendrequest1(receiverId);
		System.out.println(userIds);
		
		if(!userIds.isEmpty()){
			return userprofiledao.getMobileNumber(userIds);
		}
		
		return null;
	}

	@Override
	public List<Long> getAllFriendrequest2(Integer senderId) {
		List<Integer> userIds = friendrequestdao.getAllFriendrequest2(senderId);
		System.out.println(userIds);
		if(!userIds.isEmpty()){
			return userprofiledao.getMobileNumber(userIds);
		}
		
		return null;
	}

	@Override
	public Long getUserMobileNum(Integer userId) {
		
		return userprofiledao.getUserMobileNum(userId);
	}

	@Override
	public void sendMsg(Message message) {
		messageDao.save(message);
		
	}

	@Override
	public List<Message> getAllMessages(Long mobileNum) {
		
		return messageDao.getAllMessages(mobileNum);
	}

	@Override
	public String getUserName1(Integer userId) {
		
		return userprofiledao.getUserName1(userId);
	}
	
	
}
