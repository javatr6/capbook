package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.model.Address;



public interface IAddressService {

	public List<Address> saveDetails(Address addr,Integer userid);

	public List<Address> getAllDetails();
	
//	public Integer saveUserId(@PathParam("user") Integer userId);
	
	
}
