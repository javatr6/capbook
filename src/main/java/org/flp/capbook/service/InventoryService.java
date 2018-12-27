package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IStatusDao;
import org.flp.capbook.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class InventoryService implements IinventoryService{
	
	@Autowired
	private IStatusDao imageDao;
	
	

	@Override
	public Boolean saveImage(Status status) {
		if(imageDao.save(status)!=null) {
			return true;
			}
			return false;  
	}
	


} 
 
