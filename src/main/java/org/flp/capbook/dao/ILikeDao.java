package org.flp.capbook.dao;

import org.flp.capbook.model.Likes;
import org.flp.capbook.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository("likeDao")
public interface ILikeDao extends JpaRepository<Likes, Integer> {

	@Query("from Status where status_id=:status_id")
	Status findStatus(Integer status_id);
	@Query("from Likes where status_id=:status_id and liked_by=:liked_by")
	Likes findLikeByStatus(@Param("status_id")Integer status_id, @Param("liked_by")Integer liked_by);
	@Query("select count(*) from Likes where like_count=1 and status_id=:status_id")
	Integer getLikeCount(Integer status_id);
	@Query("select count(*) from Likes where dislike_count=1 and status_id=:status_id")
	Integer getDislikeCount(Integer status_id);

}
