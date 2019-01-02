package org.flp.capbook.service;

import java.sql.Date;
import java.util.List;


import org.flp.capbook.model.UserProfile;



public interface IBirthdayService {
	public  List<String> getDetails(Integer recid);
	public  List<String> getDetails1(Integer recid);
/*	public  List<String> getUsername(Integer recid);*/


}
