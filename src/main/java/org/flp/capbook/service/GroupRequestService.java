package org.flp.capbook.service;


import java.util.List;

import org.flp.capbook.dao.IGroupRequestDao;
import org.flp.capbook.model.Group_Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("GrouprequestService")
public class GroupRequestService implements IGroupRequestService{

	@Autowired
	private IGroupRequestDao requestDao;
	
	
	@Override
	public List<Group_Request> requestSent(Group_Request request) {

		requestDao.save(request);
		return requestDao.findAll();
	}

	@Override
	public List<Group_Request> findRequest() {
		List<Group_Request> list =requestDao.findAll();
		return list;
	}

}
