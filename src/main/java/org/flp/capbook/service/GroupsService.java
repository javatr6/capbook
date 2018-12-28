package org.flp.capbook.service;
import java.util.List;

import org.flp.capbook.dao.IFriendsDao;
import org.flp.capbook.dao.IGroupTopicDao;
import org.flp.capbook.dao.IGroupsDao;
import org.flp.capbook.model.FriendsList;
import org.flp.capbook.model.Group_Topic;
import org.flp.capbook.model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("groupService")
public class GroupsService implements IGroupsService {
	
	@Autowired
	private IGroupsDao groupsDao;
	@Autowired
	private IFriendsDao friendsDao;
	@Autowired
	private IGroupTopicDao groupTopicDao;

	@Override
	public List<FriendsList> findFriends() {
		List<FriendsList> list =friendsDao.findAll();
	return list;
	}

	@Override
	public List<Groups> createGroup(Groups groups) {
		groupsDao.save(groups);
		return groupsDao.findAll();
	}

	@Override
	public List<Group_Topic> post(Group_Topic topic) {
		groupTopicDao.save(topic);
		return groupTopicDao.findAll();
	}
	@Override
	public List<FriendsList> exitFriends(Integer id) {
		
		 friendsDao.deleteById(id);
		 
		 return friendsDao.findAll();
	}

}
