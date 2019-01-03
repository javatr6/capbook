package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IMsgDao;
import org.flp.capbook.model.MessageT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("msgService")
public class MsgServiceImpl implements IMsgService {
	@Autowired
	private IMsgDao msgDao;
	
	@Override
	public List<MessageT> saveMessage(MessageT message) {
		msgDao.save(message);
		return msgDao.findAll();
	}

	@Override
	public List<MessageT> getAllMessages() {
		return msgDao.findAll();
	}

	@Override
	public List<MessageT> getChatMessage(Integer user_id, Integer rec_id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
