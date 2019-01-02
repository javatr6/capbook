package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.model.Address;
import org.flp.capbook.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProfileSettings")
@CrossOrigin("*")
public class AddressController {

	
	@Autowired
	private IAddressService addressService;
	

	@GetMapping("/addr")
	public ResponseEntity<List<Address>> getPassword(){
		
		List<Address> adddetails=addressService.getAllDetails();
		
		if(adddetails.isEmpty())
			return new ResponseEntity("Sorry! No Address found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Address>>(adddetails, HttpStatus.OK); 
	}
	
	@PostMapping("/saveAddr/{userid}")
    ResponseEntity<List<Address>> postAddress(@RequestBody Address address,@PathVariable("userid") Integer userid)	{
		
		List<Address> addr= addressService.saveDetails(address,userid);
		
		System.out.println("in controller");
		System.out.println("controller user id"+ userid);
		
				if(addr.isEmpty())
		{
			return new ResponseEntity("Sorry! unable to add address", 
					HttpStatus.NOT_FOUND); 
		}
		
		return new ResponseEntity<List<Address>>(addr, HttpStatus.OK);
	}

}
