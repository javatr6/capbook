package org.flp.capbook.service;

import java.sql.Date;
import java.util.List;

import org.flp.capbook.model.Address;
import org.flp.capbook.model.UserProfile;



public interface IAddressService {

	public List<Address> saveDetails(Address addr,Integer userid);

	public List<Address> getAllDetails();
	
	public List<UserProfile> update(Integer userid, Date dob, Long mobile, Boolean visibility);


	
	
} 