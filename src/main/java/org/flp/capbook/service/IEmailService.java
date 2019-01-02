package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Email;



public interface IEmailService {
	List<Email> saveEmail(Email email);
	List<Email> getAllEmailsOfUser(String emailId);
	String getUserEmail( Integer userId);

}
