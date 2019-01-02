package org.flp.capbook.dao;
import java.util.List;

import org.flp.capbook.model.Group_Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;





@Repository("groupRequestDao")
@Transactional
public interface IGroupRequestDao extends JpaRepository<Group_Request, Integer>{
	@Query("select g from Group_Request g where g.groupId =:groupId and g.status='accept'")
	public List<Group_Request> getAllGroupMembers(@Param("groupId") Integer groupId);
	
	@Query("select g from Group_Request g  where g.groupId =:groupId and g.userId=:userId")
	public  List<Group_Request> deleteGroupMember(@Param("groupId") Integer groupId,@Param("userId") Integer userId);
	
	
	@Query("select g from Group_Request g  where g.groupId =:groupId and g.status='pending'")
	public List<Group_Request> getAllGroupRequests(@Param("groupId") Integer groupId);

	@Modifying
	@Query( "update Group_Request  set status = 'accept'  WHERE g_requestId = :groupRequestId")
	public void updateStatus(@Param("groupRequestId") Integer groupRequestId);

}