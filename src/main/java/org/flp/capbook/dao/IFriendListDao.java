package org.flp.capbook.dao;

import java.sql.Date;
import java.util.List;

import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("friendlistdao")
@Transactional

public interface IFriendListDao extends JpaRepository<Friend_request,Integer>{

	@Query(value="select user_name from user_profile where user_id in (select sender_id from friend_request where receiver_id=:id and status ='accept')",nativeQuery=true)
	
	public List<String> getAllFriendList(@Param("id")Integer userId);
	
	
	/*@Query(value="select user_name from user_profile where user_id in (select receiver_id from friend_request where sender_id=:id  and status ='accept')",nativeQuery=true)
	public List<String> getAllFriendrequest2(@Param("id")Integer userId);*/
	
}



