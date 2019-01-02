package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IGroupSearchDao;
import org.flp.capbook.dao.IUserSearchDao;
import org.flp.capbook.model.Groups;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("searchService")
public class SearchServiceImpl implements IGroupSearchService{
	
	@Autowired
	private IUserSearchDao userSearchDao;
	
	@Autowired
	private IGroupSearchDao groupsearchDao;

	@Override
	public List<String> getGroupNames(String letter) {
		return groupsearchDao.getGroupNames(letter);
	}

	@Override
	public List<String> getUserName(String username) {
		
		return userSearchDao.getUserName(username);
	}

	@Override
	public List<Groups> getAllGroupNames() {
		
		return groupsearchDao.findAll();
	}

	@Override
	public List<UserProfile> getAllUserNames() {
		
		return userSearchDao.findAll();
	}

}
