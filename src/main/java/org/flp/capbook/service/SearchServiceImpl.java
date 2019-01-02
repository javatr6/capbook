package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.ISearchDao;
import org.flp.capbook.dao.IUserSearchDao;
import org.flp.capbook.model.Groups;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("searchService")
public class SearchServiceImpl implements ISearchService{
	
	@Autowired
	private ISearchDao searchDao;
	
	@Autowired
	private IUserSearchDao userSearchDao;

	@Override
	public List<String> getGroupNames(String letter) {
		return searchDao.getGroupNames(letter);
	}

	@Override
	public List<String> getUserName(String username) {
		
		return userSearchDao.getUserName(username);
	}

	@Override
	public List<Groups> getAllGroupNames() {
		
		return searchDao.findAll();
	}

	@Override
	public List<UserProfile> getAllUserNames() {
		
		return userSearchDao.findAll();
	}

}
