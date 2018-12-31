package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Groups;
import org.flp.capbook.model.UserProfile;

public interface IGroupSearchService {
	
	public List<String> getGroupNames(String letter);

	public List<String> getUserName(String username);

	public List<Groups> getAllGroupNames();

	public List<UserProfile> getAllUserNames();

}
