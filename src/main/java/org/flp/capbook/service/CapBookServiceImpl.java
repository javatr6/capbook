package org.flp.capbook.service;

import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.flp.capbook.dao.IEmailDao;
import org.flp.capbook.dao.IFriendDao;
import org.flp.capbook.dao.ILoginDao;
import org.flp.capbook.dao.IUserDao;
import org.flp.capbook.model.ChangePassword;
import org.flp.capbook.model.Email;
import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.Login;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("friendservice")
public class CapBookServiceImpl implements ICapBookService{

	@Autowired
	private IFriendDao frienddao;
	@Autowired
	private IUserDao userProfile;
	@Autowired
	private ILoginDao loginDao;
	/*@Autowired
	private IPasswdDao psswdDao;*/

	@Autowired
	private IEmailDao emailDao;

	private Base64 base64 = new Base64();
	@Override
	public List<Friend_request> saveFriend(Friend_request friend) {

		frienddao.save(friend);

		return frienddao.findAll();


	}

	@Override
	public List<Friend_request> getFriend() {

		return frienddao.findAll();


	}

	@Override
	public List<UserProfile> saveUser(UserProfile userprofile) {
		userProfile.save(userprofile);
		return userProfile.findAll();

	}

	@Override
	public List<Login> savelogin(Login login) {
		String encodedString = new String(base64.encode(login.getPassword().getBytes()));
		login.setPassword(encodedString); 
		loginDao.save(login);

		return loginDao.findAll();
	}

	/*@Override
	public List<ChangePassword> savepsswrd(ChangePassword changepsswd) {
		String encodedString = new String(base64.encode(changepsswd.getOldPassword().getBytes()));
		
		changepsswd.setOldPassword(encodedString);
		
		psswdDao.save(changepsswd);
		return psswdDao.findAll();
	}*/

	@Override
	public List<Login> getLoginDetails() {

		return loginDao.findAll();
	}

	/*@Override
	public List<ChangePassword> getPsswrdDetails() {


		return psswdDao.findAll();
	}*/

	@Override
	public List<UserProfile> getUserDetails() {
		// TODO Auto-generated method stub
		return userProfile.findAll();
	}

	@Override
	public Login findByUsername(String email) {

		Login lgn=loginDao.findByUsername(email);
       System.out.println(lgn);
		return lgn;
	}

	/*@Override
	public String getPassword(String mail) {
		String pwd=psswdDao.getPassword(mail);
		return pwd; 
	}
*/
	@Override
	public List<Email> saveEmaildetails(Email email) {

		
		emailDao.save(email);
		return emailDao.findAll();



	}

	/*@Override
	public String getMail(Integer userId) {
		
		String mail=psswdDao.getMail(userId);
		System.out.println(mail);
		return mail;
	}
*/
	@Override
	public String getPsswdBymail(String mail) {
		 String psswd=loginDao.getPsswdBymail(mail);
		String password = new String(base64.decode(psswd.getBytes()));
		System.out.println("password");
		return password;
	}

	/*@Override
	public List<ChangePassword> saveNewPwd(ChangePassword changePwd) {
		psswdDao.save(changePwd);
		return psswdDao.findAll();
	}*/

	/*@Override
	public Integer saveNewPasswd(String mail,String Op, String Np) {
        psswdDao.saveNewPasswd(Op, Np, mail);
		return 1;*/
	//}

	@Override
	public Integer saveLgnPasswd(String Password, String email) {
		String passwd = new String(base64.encode(Password.getBytes()));
		System.out.println(passwd);
		loginDao.saveLgnPasswd(passwd, email);
			return 1;
	
	}

	@Override
	public String getPassword(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMail(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}







}
