package org.flp.capbook.service;

import java.sql.Date;
import java.util.List;

import org.flp.capbook.dao.IAddressdao;
import org.flp.capbook.dao.IUserDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.Address;
import org.flp.capbook.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressdao addressDao;
     
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IUserProfileDao userProfileDao;

	UserProfile up=new UserProfile();
	
	@Override
	public List<Address> saveDetails(Address addr,Integer userid)  {
		
		Address address= addressDao.getByUser(userid);
		System.out.println(address);
		System.out.println("servu"+userid);
		if(address!=null) {
			address.setCity(addr.getCity());
			address.setDoorNumber(addr.getDoorNumber());		
			address.setLocality(addr.getLocality());
			address.setState(addr.getState());
			address.setStreet(addr.getStreet());
			address.setUserId(userid);
			System.out.println("hi");
			addressDao.save(address);

		}
		else {
			addressDao.save(addr);
		}
		System.out.println(addr);
		
		
		System.out.println(userid);
		return addressDao.findAll();
	}

	@Override
	public List<Address> getAllDetails() {

		return addressDao.findAll();
	}

	@Override
	public List<UserProfile> update(Integer userid, Date dob, Long mobile, Boolean visibility) {
		
	UserProfile up= userProfileDao.findByUserId(userid);
	up.setDob(dob);
	up.setMobileNo(mobile);
	up.setVisibility(visibility);
	userDao.save(up);
		return  userDao.findAll();
	}

} 