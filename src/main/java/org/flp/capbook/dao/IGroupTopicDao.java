package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Group_Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository("groupTopicDao")
@Transactional
public interface IGroupTopicDao extends JpaRepository<Group_Topic, Integer>{
	@Query("from Group_Topic t where t.group_id=:groupId")
	List<Group_Topic> findGroupTopics(@Param("groupId")Integer groupId);
	@Query("select g from Group_Topic g where g.group_id =:groupId")
	public List<Group_Topic> getAllTopics(@Param("groupId") Integer groupId);
	
	
	@Query("select g from Group_Topic g where g.group_id =:groupId and g.topic_id=:topicId")
	public List<Group_Topic> deleteTopic(@Param("groupId") Integer groupId,@Param("topicId") Integer topicId);
	

}
