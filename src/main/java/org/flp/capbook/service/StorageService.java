package org.flp.capbook.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.flp.capbook.dao.IProfileDao;
import org.flp.capbook.dao.IStatusDao;
import org.flp.capbook.dao.IUserDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.Images;
import org.flp.capbook.model.Status;
import org.flp.capbook.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;




@Service("profileService")
public class StorageService {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	private  final Path rootLocation = Paths.get("C:\\Users\\vpullamb\\Desktop\\images\\src\\main\\resources\\static\\upload");

	@Autowired
	private IProfileDao profiledao;

	@Autowired
	private IUserProfileDao userProfileDao;
	
	
	
	@Autowired
	private IStatusDao statusDao;

	public void store(MultipartFile files[],String location,Integer userId) {


		try {
			System.out.println("Before for Loop");
			for(MultipartFile file:files) {
				System.out.println("Inside for Loop");
				Path rootlocation1= init(userId,location);
				System.out.println("after init");
				Files.copy(file.getInputStream(), rootlocation1.resolve(file.getOriginalFilename()));
				System.out.println("File Name: "+file.getOriginalFilename());
				Images image =new Images();
				image.setAlbumName(location);
				image.setUserId(userId);
				image.setImageUrl(rootlocation1.resolve(file.getOriginalFilename()).toString());
				profiledao.save(image);

			}
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}
	}



	public Resource loadFile(String filename, Integer userId, String location) {

		//Path rootLocation = Paths.get(path);
		Path rootLocation1 = Paths.get("C:\\Users\\vpullamb\\Desktop\\images\\src\\main\\resources\\static\\upload\\"+userId+"\\"+location);
		try {
			Path file = rootLocation1.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		//	Path rootLocation = Paths.get(path);
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public Path init(Integer userId, String location){

		try {
			System.out.println("insisde init");
			Path rootLocation1 = Paths.get("C:\\Users\\vpullamb\\Desktop\\images\\src\\main\\resources\\static\\upload");
			File file=new File(this.rootLocation.toUri());
			if(!file.isDirectory()) {
				Files.createDirectory(rootLocation);
			}
			rootLocation1 = Paths.get("C:\\Users\\vpullamb\\Desktop\\images\\src\\main\\resources\\static\\upload\\"+userId);
			file=new File(rootLocation1.toUri());
			if(!file.isDirectory()) {
				Files.createDirectory(rootLocation1);
			}
			rootLocation1 = Paths.get("C:\\Users\\vpullamb\\Desktop\\images\\src\\main\\resources\\static\\upload\\"+userId+"\\"+location);
			file=new File(rootLocation1.toUri());
			if(!file.isDirectory()) {
				Files.createDirectory(rootLocation1);
			}
			return rootLocation1;	
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}



	public List<String> getAllFiles(Integer userId, String location) {
		List<String> files1=new ArrayList<>();
		List<String> files=new ArrayList<>();
		if(location.equals("profile")) {
			Integer maxId=profiledao.getMaxId(userId);
			files=profiledao.getProfilePic(userId,maxId);
		}
		else {
			files=profiledao.getImage(userId,location);
		}
		for(String url:files) {
			File file=new File(url);
			System.out.println(file.getName());
			files1.add(file.getName());
		}
		return files1;
	}
	public void store(Status status,Integer userId) {
		
		try {
			
			UserProfile user=userProfileDao.find(userId);
			if(user==null) {
				System.out.println("Im null");
			}else {
				status.setUserName(user.getUserName());
				status.setUser(user);
				statusDao.save(status);}  
			} catch (Exception e) {
				System.out.println(e.getMessage()  );
				
			}
		}
		
		public boolean deleteStatus(Integer status_id) {
			
			Status s=statusDao.findStatus(status_id);	
			
			statusDao.delete(s);
			return true;
			
		}
	 
		
	 
		

		public List<Status> getStatus(Integer userId) {
			
			return statusDao.getStatus(userId);
		}

}