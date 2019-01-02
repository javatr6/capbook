package org.flp.capbook.service;

import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userServiceGroups")
public class UserServiceGroups implements IUserServiceGroups {

	@Autowired
	private IUserProfileDao userProfileDao;

	@Override
	public UserProfile findGroupsuser(Integer input) {
	
		return userProfileDao.findByUserId(input);
	}
}
