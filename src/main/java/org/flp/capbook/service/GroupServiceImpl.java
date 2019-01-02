package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IGroupRequestDao;
import org.flp.capbook.dao.IGroupTopicDao;
import org.flp.capbook.dao.IGroupsDao;
import org.flp.capbook.dao.IUserProfileDao;
import org.flp.capbook.model.Group_Request;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class GroupServiceImpl implements IGroupService{
	
	@Autowired
	private IGroupsDao groupsDao;
	
	@Autowired
	private IGroupTopicDao groupTopicDao;
	
	@Autowired
	private IGroupRequestDao groupRequestDao;
	

	@Autowired
	private IUserProfileDao userDao;
	
	@Override
	public List<Groups> getAllGroups(Integer userId) {
		
		//String groupAdmin=groupsDao.getGroupAdmin(userId);
		
		return groupsDao.getAllGroups(userId);
	}


	@Override
	public List<Group_Topic> getAllTopics(Integer groupId) {
		return groupTopicDao.getAllTopics(groupId);
		
	}


	@Override
	public List<Group_Topic> deleteTopic(Integer groupId, Integer topicId) {
		System.out.println("in delete service");
		groupTopicDao.deleteById(topicId);
		return groupTopicDao.getAllTopics(groupId);
	}


	@Override
	public List<Group_Request> getAllGroupMembers(Integer groupId) {
		List<Group_Request> members=groupRequestDao.getAllGroupMembers(groupId);
		for(Group_Request member:members) {
			System.out.println("for each loop");
			member.setUserName(userDao.getUserName(member.getUserId()));
			
		}
		
		return members ;
	}


	@Override
	public List<Group_Request> deleteGroupMember(Integer groupId, Integer userId) {
		 List<Group_Request>groups=groupRequestDao.deleteGroupMember(groupId, userId);

		 for( Group_Request group: groups)
		 {
			 groupRequestDao.delete(group);
			 
		 }
		 
		 return groupRequestDao.getAllGroupMembers(groupId);
	}


	@Override
	public List<Group_Request> getAllGroupRequests(Integer groupId) {
		List<Group_Request> approve=groupRequestDao.getAllGroupRequests(groupId);
		for(Group_Request app:approve) {
			System.out.println("for each loop");
			app.setUserName(userDao.getUserName(app.getUserId()));
			System.out.println(app);
		}
		
		return approve ;
		
	}


	@Override
	public List<Group_Request> updateStatus(Group_Request approve) {
		
//		groupRequestDao.updateStatus(approve.getG_requestId());
//		return groupRequestDao.getAllGroupRequests(approve.getGroupId());
		groupRequestDao.save(approve);
		return groupRequestDao.findAll();
	}

}
