package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.ILoginDao;
import org.flp.capbook.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService implements ILoginService {

	@Autowired
	private ILoginDao loginDao;

	@Override
	public Boolean checkUser(Login login) {

		List<Login> users= loginDao.findAll();

		for(Login user:users) {


			if(user.getEmail().equals(login.getEmail())) {
				if(user.getPassword().equals(login.getPassword())) {
					if(user.getStatus().equals("Activated")) {
						return true;
					}
				}

			}

		}

		return false;
	}


}
