package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IAddressdao;
import org.flp.capbook.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("addressService")
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private IAddressdao addressDao;


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

}
