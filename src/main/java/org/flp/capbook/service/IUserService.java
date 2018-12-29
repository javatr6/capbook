package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.UserProfile;

public interface IUserService {

	UserProfile getUserDetails(String email);

}
