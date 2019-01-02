package org.flp.capbook.service;

import java.util.List;

import org.flp.capbook.dao.IGroupCommentDao;
import org.flp.capbook.dao.IGroupTopicDao;
import org.flp.capbook.dao.IGroupsDao;
import org.flp.capbook.model.Group_Comments;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("groupService")
public class GroupsService implements IGroupsService {
	
	@Autowired
	private IGroupsDao groupsDao;
	
	@Autowired
	private IGroupTopicDao groupTopicDao;
	@Autowired
	private IGroupCommentDao commentDao;

	/*@Override
	public List<FriendsList> findFriends(Integer groupId) {
		List<FriendsList> list =friendsDao.findFriendsByGroupId(groupId);
	return list;
	}*/

	@Override
	public Groups createGroup(Groups groups) {
		groupsDao.save(groups);
	
	return groupsDao.findByGroupName(groups.getGroupName());
	}

	@Override
	public List<Group_Topic> post(Group_Topic topic) {
		if(topic.getTopic_desc()==null||topic.getTopic_desc()=="") {
			
			return groupTopicDao.findGroupTopics(topic.getGroup_id());
		
		}
		groupTopicDao.save(topic);
		return groupTopicDao.findGroupTopics(topic.getGroup_id());
	}
	/*@Override
	public List<FriendsList> exitFriends(Integer id) {
		
		 friendsDao.deleteById(id);
		 
		 return friendsDao.findAll();
	}
*/
	@Override
	public List<Group_Comments> postComment(Group_Comments group_comments) {
		commentDao.save(group_comments);
	
		return commentDao.getGroupComments(group_comments.getTopicId());
	}

	
}
