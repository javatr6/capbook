package org.flp.capbook.dao;

import java.util.List;

import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("birthdaydao1")
@Transactional
public interface IBirthdayDao extends JpaRepository<UserProfile, Integer>{
	@Query(value="select user_name from user_profile u where u.user_id in(select f.sender_id from friend_request f where f.receiver_id = :input and f.status='approved') and month( u.dob)=month(current_date()) and  day ( u.dob)=day(current_date());",nativeQuery=true)
	List<String> getDob(@Param("input") Integer input);
	
	@Query(value="select user_name from user_profile u where u.user_id in(select f.receiver_id from friend_request f where f.sender_id = :input1 and f.status='approved') and month( u.dob)=month(current_date()) and  day ( u.dob)=day(current_date());",nativeQuery=true)
	List<String> getDob1(@Param("input1") Integer input1);
}
	/*
	@Query(value="select user_name from user_profile u where u.user_id in(select f.sender_id from friend_request f where f.receiver_id = :input and f.status='approved')",nativeQuery=true)
	List<String> getUsername(@Param("input") Integer input);

	@Query(value="select dob from user_profile u where u.user_id in(select f.sender_id from friend_request f where f.receiver_id = :input and f.status='approved')",nativeQuery=true)
	List<Date> getDob(@Param("input") Integer input);

	
	@Query(value="select user_name from user_profile u where u.user_id in(select f.sender_id from friend_request f where f.receiver_id = :input and f.status='approved')",nativeQuery=true)
	List<String> getUsername(@Param("input") Integer input);
}*/
