package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IProfileaboutmeDao;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("profileaboutmeService")
public class ProfileaboutmeImpl implements IProfileaboutmeService{
	
	@Autowired
	private IProfileaboutmeDao profileaboutmeDao;

	@Override
	public UserProfile getAllDetails(Integer id) {
		
		return profileaboutmeDao.getAllDetails(id);
	}

	
}
