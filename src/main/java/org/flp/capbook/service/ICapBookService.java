package org.flp.capbook.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.flp.capbook.model.ChangePassword;
import org.flp.capbook.model.Email;
import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.Login;
import org.flp.capbook.model.UserProfile;


public interface ICapBookService {

	List<Friend_request> saveFriend(Friend_request friend);
	
	List<Friend_request> getFriend();
	
	
	List<UserProfile> saveUser(UserProfile userprofile);
	
	List<Login> savelogin(Login login);
	
	//List<ChangePassword> savepsswrd(ChangePassword changepsswd);
	
	List<Login> getLoginDetails();
	
	//List<ChangePassword> getPsswrdDetails();
	
	List<UserProfile> getUserDetails();
	
	public Login findByUsername( String email);
	
	public String getPassword(@PathParam("email") String mail);
    
	List<Email> saveEmaildetails(Email email);
	
	public String getMail(Integer userId);
	
	public String getPsswdBymail(String mail);
	
//	public List<ChangePassword> saveNewPwd(ChangePassword changePwd);
	
/*	public Integer saveNewPasswd(String mail,String Op, String Np);*/
	
	public Integer saveLgnPasswd(String Password,String email);
}
