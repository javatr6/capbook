package org.flp.capbook.controller;


import java.util.List;

import org.flp.capbook.dao.IGroupCommentDao;
import org.flp.capbook.dao.IGroupsDao;
import org.flp.capbook.dao.IRequestDao;
import org.flp.capbook.model.Group_Comments;
import org.flp.capbook.model.Group_Request;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;
import org.flp.capbook.model.UserProfile;
import org.flp.capbook.service.IGroupNameService;
import org.flp.capbook.service.IGroupService;
import org.flp.capbook.service.IGroupsService;
import org.flp.capbook.service.IRequestService;
import org.flp.capbook.service.ISearchService;
import org.flp.capbook.service.IUserServiceGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("http://localhost:4200")
public class GroupsController {

	@Autowired
	private ISearchService searchService;
	
	@Autowired
	private IUserServiceGroups userServiceGroups;
	
	@Autowired
	private IGroupsService groupService;
	@Autowired
	private IRequestService requestService;

	@Autowired
	private IGroupNameService groupNameService;
	
	
	@Autowired
	private IGroupsDao groupsDao;
	@Autowired
	private IGroupCommentDao commentDao;
	@Autowired
	private IRequestDao requestDao;
	
	
	
	@Autowired
	private IGroupService groupService1;
	
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
	@GetMapping("/groups/findUser/{input}")
	public ResponseEntity<UserProfile> findUserName(@PathVariable("input") Integer input){
		
		UserProfile groupsname=userServiceGroups.findGroupsuser(input);
		
		if(groupsname==null) {
			
			return new ResponseEntity("No Groups available",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<UserProfile>(groupsname,HttpStatus.OK);
		
	}
	
	/*@GetMapping("/findall/{groupId}")
	public ResponseEntity<List<FriendsList>> findFriends(@PathVariable("groupId")Integer groupId){
		//List<FriendsList> friendsList=groupService.findFriends(groupId);
		List<FriendsList> friendsList = null;
		return new ResponseEntity<List<FriendsList>>(friendsList, HttpStatus.OK);
	}*/
	
	@PostMapping("/creategroup")
	public ResponseEntity<Groups> createGroup(@RequestBody Groups groups){
		Groups group=groupService.createGroup(groups);
		
		System.out.println("*******************"+group);
		return new ResponseEntity<Groups>(group, HttpStatus.OK);
		
	}
	@PostMapping("/comment")
	public ResponseEntity<List<Group_Comments>> postComment(@RequestBody Group_Comments group_Comments){
		List<Group_Comments> grouptopics=groupService.postComment(group_Comments);
		
		System.out.println("*******************"+grouptopics);
		return new ResponseEntity<List<Group_Comments>>(grouptopics, HttpStatus.OK);
		
	}
	@PostMapping("/postT")
	public ResponseEntity<List<Group_Topic>> postT(@RequestBody Group_Topic topic){
		System.out.println(topic);
		List<Group_Topic> postTList=groupService.post(topic);
		return new ResponseEntity<List<Group_Topic>>(postTList,HttpStatus.OK);
	}
	
	
	/*@DeleteMapping("/exitUser/{id}")
	public ResponseEntity<List<FriendsList>> exitFriends(@PathVariable("id")Integer id){
		List<FriendsList> friends= groupService.exitFriends(id);
		if(friends.isEmpty() || friends==null) {
			return new ResponseEntity("Sorry! UserId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<FriendsList>>(friends, HttpStatus.OK);
		
	}*/
	@DeleteMapping("/exitUser/{id}")
	public ResponseEntity<List<Group_Request>> exitFriends(@PathVariable("id")Integer id){
		List<Group_Request> friends= requestService.getRequestIdAndDelete(id);
		if(friends.isEmpty() || friends==null) {
			return new ResponseEntity("Sorry! UserId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Group_Request>>(friends, HttpStatus.OK);
		
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
	@GetMapping("/getComments/{topicId}")
	public ResponseEntity<List<Group_Comments>> getCommentsForTopic(@PathVariable("topicId") Group_Topic topicId){
		List<Group_Comments> commentsList = commentDao.getGroupComments(topicId);
		if(commentsList.isEmpty()) {
			return new ResponseEntity("Sorry no comments for this topic", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Group_Comments>>(commentsList, HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping("/names")
	public ResponseEntity<List<Groups>> getAllGroupNames(){
		
		List<Groups> names= searchService.getAllGroupNames();
		if(names.isEmpty())
			return new ResponseEntity(
					"Sorry! Group info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Groups>>(names, HttpStatus.OK);
	}
	
	@GetMapping("/unames")
	public ResponseEntity<List<UserProfile>> getAllUserNames(){
		
		List<UserProfile> unames= searchService.getAllUserNames();
		if(unames.isEmpty())
			return new ResponseEntity(
					"Sorry! User info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<UserProfile>>(unames, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/names/{letter}")
	public ResponseEntity<List<String>> getGroupNames(@PathVariable("letter") String letter){
		System.out.println(letter);
		List<String> names= searchService.getGroupNames(letter);
		if(names.isEmpty())
			return new ResponseEntity(
					"Sorry! Group info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<String>>(names, HttpStatus.OK);
	}
	
	@GetMapping("/unames/{username}")
	public ResponseEntity<List<String>> getUserNames(@PathVariable("username") String username){
		System.out.println(username);
		List<String> names= searchService.getUserName(username);
		if(names.isEmpty())
			return new ResponseEntity(
					"Sorry! User info not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<String>>(names, HttpStatus.OK);
	}
	
	
	@GetMapping("/getGroups/{userId}")
	public ResponseEntity<List<Groups>> getAllGroups(
			@PathVariable("userId") Integer userId){
		

		List<Groups> groups= groupService1.getAllGroups(userId);
		if(groups.isEmpty())
		{
			return new ResponseEntity("Sorry! No groups  available!", 
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Groups>>(groups, HttpStatus.OK);

	} 
	@GetMapping("/groupTopics/{groupId}")
	public ResponseEntity<List<Group_Topic>> getAllTopics(
			@PathVariable("groupId")Integer groupId){
		
		List<Group_Topic> topics= groupService1.getAllTopics(groupId);
		if(topics.isEmpty())
		{
			return new ResponseEntity("Sorry! topics not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Group_Topic>>(topics, HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteTopics/{groupId}/{topicId}")
	public ResponseEntity<List<Group_Topic>> deleteTopic(
			@PathVariable("groupId")Integer groupId,
			@PathVariable("topicId")Integer topicId){
		List<Group_Topic> topics= groupService1.deleteTopic(groupId, topicId);
		if(topics.isEmpty() || topics==null) {
			return new ResponseEntity("Sorry! topics not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Group_Topic>>(topics, HttpStatus.OK);
	} 
	
	@GetMapping("/getAllGroupMembers/{groupId}")
	public ResponseEntity<List<Group_Request>> getAllGroupMembers(
			@PathVariable("groupId")Integer groupId){
		
		List<Group_Request> groupMembers= groupService1.getAllGroupMembers(groupId);
		if(groupMembers.isEmpty())
		{
			return new ResponseEntity("Sorry! members not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Group_Request>>(groupMembers, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteGroupMember/{groupId}/{userId}")
	public ResponseEntity<List<Group_Request>> deleteGroupMember(
			@PathVariable("groupId")Integer groupId,
			@PathVariable("userId")Integer userId){
		List<Group_Request> groupMembers= groupService1.deleteGroupMember(groupId, userId);
		if(groupMembers.isEmpty())
		{
			return new ResponseEntity("Sorry! members not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Group_Request>>(groupMembers, HttpStatus.OK);
	}
	@GetMapping("/getAllGroupRequests/{groupId}")
	public ResponseEntity<List<Group_Request>> getAllGroupRequests(
			@PathVariable("groupId")Integer groupId){
		
		List<Group_Request> grouprequests= groupService1.getAllGroupRequests(groupId);
		if(grouprequests.isEmpty())
		{
			return new ResponseEntity("Sorry! requests not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Group_Request>>(grouprequests, HttpStatus.OK);
		
	}
	
	@PutMapping("/status")
	public ResponseEntity<List<Group_Request>> getStatus(@RequestBody Group_Request approve){
		
		List<Group_Request> approves= groupService1.updateStatus(approve);
		if(approves.isEmpty())
			return new ResponseEntity(
					"Sorry! requests not available", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Group_Request>>(approves, HttpStatus.OK);
	}
	
	
}
