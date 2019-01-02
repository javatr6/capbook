package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Friend_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("onlineDao")
@Transactional
public interface IOnlineDao extends JpaRepository<Friend_request, Integer>{
//    @Query(value="select email from user_profile where user_id in (select sender_id from friend_request where receiver_id=:id and status ='accept')",nativeQuery=true)
    @Query("select f.senderId from Friend_request f where f.receiverId=:id and f.status ='accepted'")
	public List<Integer> getAllUserMails1(@Param("id")Integer userId);
	
	
//	@Query(value="select email from user_profile where user_id in (select receiver_id from friend_request where sender_id=:id  and status ='accept')",nativeQuery=true)
	@Query("select f.receiverId from Friend_request f where f.senderId=:id  and f.status ='accepted'")
	public List<Integer> getAllUserMails2(@Param("id")Integer userId);
	
	@Query(value="select u.user_name from login l,user_profile u where l.email in :email and l.email=u.email and l.active_status='online'",nativeQuery=true)
	public List<String> getAllUserNames(@Param("email") List<String> email);
}
