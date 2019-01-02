package org.flp.capbook.service;
import java.util.List;

import org.flp.capbook.model.Group_Request;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;



public interface IGroupService {

	List<Groups> getAllGroups(Integer userId);

	List<Group_Topic> getAllTopics(Integer groupId);

	List<Group_Topic> deleteTopic(Integer groupId, Integer topicId);

	List<Group_Request> getAllGroupMembers(Integer groupId);

	List<Group_Request> deleteGroupMember(Integer groupId, Integer userId);

	List<Group_Request> getAllGroupRequests(Integer groupId);

	List<Group_Request> updateStatus(Group_Request approve);
	
	
	

}
