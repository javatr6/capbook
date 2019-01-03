package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.MessageT;

public interface IMsgService {

	List<MessageT> saveMessage(MessageT message);

	List<MessageT> getAllMessages();

	List<MessageT> getChatMessage(Integer user_id, Integer rec_id);

}
