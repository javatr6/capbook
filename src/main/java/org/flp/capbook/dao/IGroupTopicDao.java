package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.Group_Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("groupTopicDao")
@Transactional
public interface IGroupTopicDao extends JpaRepository<Group_Topic, Integer>{

}
