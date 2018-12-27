package org.flp.capbook.controller;

import java.io.File;

import org.flp.capbook.model.Status;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.IinventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;







@RestController
@CrossOrigin(origins="*")
public class UserController {
	@Autowired
	private IinventoryService inventoryService;
		@PostMapping("/saveImage")
		public boolean saveImage(@RequestBody Status status) {
			
			try{
	    		
		    	   File afile =status.getFile();
		    		
		    	   if(afile.renameTo(new File("D:\\springgit\\capbook\\src\\main\\resources\\static\\Status\\" + afile.getName()))){
		    		System.out.println("File is moved successful!");
		    	   }else{
		    		System.out.println("File is failed to move!");
		    	   }
		    	   status.setImageUrl("D:\\springgit\\capbook\\src\\main\\resources\\static\\Status\\" + afile.getName());
		    	   
		    	    
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
			
			
			
			return inventoryService.saveImage(status);	
		}
		
	

}
