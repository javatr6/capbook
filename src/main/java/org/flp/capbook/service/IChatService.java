package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Chat;

public interface IChatService {

	List<Chat> saveChat(Chat chat);

	List<Chat> getAllChats();

	List<Chat> getChatMessage(Chat chat);

	List<Chat> getChatMessage(Integer user_id, Integer rec_id);

	Chat verifyingChat(Chat chat);


	

}
