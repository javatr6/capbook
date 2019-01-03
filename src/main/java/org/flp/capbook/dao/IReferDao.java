/*package org.flp.capbook.dao;

import java.util.List;

import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("friendrequestdao")
@Transactional

public interface IFriendRequestDao extends JpaRepository<Friend_request,Integer>{

	@Query("from Friend_request r where r.receiverId = :id or r.senderId = :id and r.status = 'accept'")
	
	public List<Friend_request> getAllFriendrequest(@Param("id")Integer userId);
	
}
*/

package org.flp.capbook.dao;

import java.util.List;

import org.flp.capbook.model.Friend_request;
import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("referdao")
@Transactional

public interface IReferDao extends JpaRepository<Friend_request,Integer>{

	@Query(value="select user_name from user_profile where user_id Not in (select receiver_id from friend_request where sender_id=:id and status ='pending' or status='accept')",nativeQuery=true)
	
	public List<String> getAllFriendrequest1(@Param("id")Integer userId);



}