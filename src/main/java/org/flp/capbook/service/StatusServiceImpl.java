package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IStatusDao;
import org.flp.capbook.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("statusService")
public class StatusServiceImpl implements IStatusService {

	@Autowired
	private IStatusDao statusDao;

	@Override
	public boolean saveStatus(Status status) {
		if(statusDao.save(status) != null) {
			return true;
		}
		return false;
		
	}

	@Override
	public List<Status> getAllStatus() {
		
		return statusDao.findAll();
	}
	
	
		} 
		 

	
	

