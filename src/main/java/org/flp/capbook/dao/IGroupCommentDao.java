package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Group_Comments;
import org.flp.capbook.model.Group_Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("commentDao")
@Transactional
public interface IGroupCommentDao extends JpaRepository<Group_Comments, Integer> {
@Query("from Group_Comments g where g.topicId=:topicId")
	List<Group_Comments> getGroupComments(@Param("topicId")Group_Topic topicId );
}
