package org.flp.capbook.dao;
import java.util.List;

import org.flp.capbook.model.Comments;
import org.flp.capbook.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository("commentdao")
@Transactional
public interface ICommentDao  extends JpaRepository<Comments,Integer>{

	@Query("from Comments where statusId=:statusId")
	public List<Comments> getAllComments(@Param("statusId")Integer statusId);
	
	@Query("from Comments where status_id=:status_id")
	public List<Comments> getAllCommentsByStatusId(@Param("status_id")Integer status_id);
	@Query("from Status where status_id=:status_id")
	public Status getStatusById(@Param("status_id") Integer status_id);
	
	@Modifying
	@Query("UPDATE Comments SET like_count=like_count+1 where status_id=:status_id and comment_id=:comment_id") 
	public Integer updateCommentLikeCount(@Param("status_id")Integer status_id,@Param("comment_id") Integer commentId);
	
	@Modifying
	@Query("UPDATE Comments SET dislike_count=dislike_count+1 where status_id=:status_id and comment_id=:comment_id") 
	public Integer updateCommentDislikeCount(@Param("status_id")Integer status_id,@Param("comment_id") Integer commentId);
	
}
