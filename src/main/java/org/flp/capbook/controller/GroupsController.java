
package org.flp.capbook.controller;

import java.util.List;

import org.flp.capbook.dao.IGroupsDao;
import org.flp.capbook.dao.IRequestDao;
import org.flp.capbook.model.FriendsList;
import org.flp.capbook.model.Group_Request;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;
import org.flp.capbook.service.IGroupNameService;
import org.flp.capbook.service.IGroupsService;
import org.flp.capbook.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("http://localhost:4200")
public class GroupsController {

	
	
	
	@Autowired
	private IGroupsService groupService;
	@Autowired
	private IRequestService requestService;
	@Autowired
	private IGroupNameService groupNameService;
	
	@Autowired
	private IGroupsDao groupsDao;
	
	@Autowired
	private IRequestDao requestDao;
	
	@GetMapping("/groupadmin/{input}")
	public ResponseEntity<List<Groups>> findGroups(@PathVariable("input") Integer input){
		
		List<Groups> groupname=groupsDao.findGroups(input);
		
		if(groupname.isEmpty()) {
			
			return new ResponseEntity("No Groups available",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Groups>>(groupname,HttpStatus.OK);
		
	}
	
	@GetMapping("/groups/{input}")
	public ResponseEntity<List<Groups>> findGroupsuser(@PathVariable("input") Integer input){
		
		List<Groups> groupsname=groupsDao.findGroupsuser(input);
		
		if(groupsname.isEmpty()) {
			
			return new ResponseEntity("No Groups available",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Groups>>(groupsname,HttpStatus.OK);
		
	}
	
	

	@GetMapping("/findall")
	public ResponseEntity<List<FriendsList>> findFriends(){
		List<FriendsList> friendsList=groupService.findFriends();
		return new ResponseEntity<List<FriendsList>>(friendsList, HttpStatus.OK);
	}
	
	@PostMapping("/creategroup")
	public ResponseEntity<List<Groups>> createGroup(@RequestBody Groups groups){
		List<Groups> groupList=groupService.createGroup(groups);
		System.out.println("*******************"+groupList);
		return new ResponseEntity<List<Groups>>(groupList, HttpStatus.OK);
		
	}
	@PostMapping("/postT")
	public ResponseEntity<List<Group_Topic>> postT(@RequestBody Group_Topic topic){
		List<Group_Topic> postTList=groupService.post(topic);
		return new ResponseEntity<List<Group_Topic>>(postTList,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/exitUser/{id}")
	public ResponseEntity<List<FriendsList>> exitFriends(@PathVariable("id")Integer id){
		List<FriendsList> friends= groupService.exitFriends(id);
		if(friends.isEmpty() || friends==null) {
			return new ResponseEntity("Sorry! UserId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<FriendsList>>(friends, HttpStatus.OK);
		
	}
	
@GetMapping("/requestfind")
	public ResponseEntity<List<Group_Request>> findRequest(){
		List<Group_Request> requestList=requestService.findRequest();
		return new ResponseEntity<List<Group_Request>>(requestList, HttpStatus.OK);
	}
	
	
	@PostMapping("/request")
	public ResponseEntity<List<Group_Request>> requestJoin(
			@RequestBody Group_Request request){
		System.out.println(request);
				List<Group_Request> requests=requestService.requestSent(request);
				if(requests.isEmpty()) {
					return new ResponseEntity("Sorry! request not available!", 
							HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<List<Group_Request>>(requests, HttpStatus.OK);
	
	
}
}
