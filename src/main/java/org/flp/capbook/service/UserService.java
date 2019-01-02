package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IUserDao;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public UserProfile getUserDetails(String email) {
		return (UserProfile) userDao.searchUser(email);
	}

	@Override
	public List<UserProfile> searchFriend(String input) {
		return userDao.searchFriend(input);
	}
}
