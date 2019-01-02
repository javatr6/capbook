package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.UserProfile;
import org.springframework.data.repository.query.Param;

public interface IProfileaboutmeService {
	
	public UserProfile getAllDetails(@Param("id")Integer id);
	


}
