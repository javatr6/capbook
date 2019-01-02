package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Status;

public interface IStatusService {

	boolean saveStatus(Status status);

	List<Status> getAllStatus();

	
	
}
