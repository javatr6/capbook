package org.flp.capbook.service;
import java.util.List;

import org.flp.capbook.dao.IChatDao;
import org.flp.capbook.model.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("chatService")
public class ChatServiceImpl implements IChatService{

	@Autowired
	private IChatDao chatDao;

	@Override
	public List<Chat> saveChat(Chat chat) {
	
		chatDao.save(chat);
		
		return chatDao.findAll();
	}

	@Override
	public List<Chat> getAllChats() {
		return chatDao.findAll();
	}

	@Override
	public List<Chat> getChatMessage(Chat chat) {
		Chat chat1=verifyingChat(chat);
		if(chat1!=null)
			return chatDao.findByChatId(chat1.getChat_Id());
		return null;
	}

	@Override
	public List<Chat> getChatMessage(Integer user_id, Integer rec_id) {
		
		Chat chat1=chatDao.VerifyingChat(user_id,rec_id);
		if(chat1!=null)
		{
			System.out.println(chat1.getChat_Id());
			return chatDao.findByChatId(chat1.getChat_Id());
		}
		return null;
	}

	@Override
	public Chat verifyingChat(Chat chat) {
		
		return chatDao.VerifyingChat(chat.getUser().getUserId(), chat.getUser_Receiver_Id());
	}
	
}
