package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IEmailDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("emailService")
public class EmailServiceImpl implements IEmailService{

	@Autowired
	private IEmailDao emailDao;
	@Autowired
	private IUserProfileDao userprofiledao;


	@Override
	public List<Email> saveEmail(Email email) {
		emailDao.save(email);

		return emailDao.findAll();
	}

	@Override
	public List<Email> getAllEmailsOfUser(String emailId) {
		return emailDao.getAllEmailsOfUser(emailId);
	}

	@Override
	public String getUserEmail(Integer userId) {
		return userprofiledao.getUserEmail(userId);
	}

}
