package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository("userProfileDao")
@Transactional
public interface IUserProfileDao extends JpaRepository<UserProfile, Integer>{
	
	UserProfile findByUserId(Integer input);
	
	@Query("select u.userName from UserProfile u where u.userId=:userId")
	String getUserName(@Param("userId") Integer userId);
	


	@Query(value="select * from user_profile where user_id=:userId",nativeQuery=true)
	UserProfile find(@Param("userId")Integer userId);
	
	
	//Retrieving emailId of a particular User
	@Query("select u.email from UserProfile u where u.userId in :userId")
	List<String> getEmail(@Param("userId")List<Integer> userId);
	
	
	@Query("select u.mobileNo from UserProfile u where u.userId in :userId")
	List<Long> getMobileNumber(@Param("userId")List<Integer> userId);
	
	@Query("select u.email from UserProfile u where u.userId=:userId")
	String getUserEmail(@Param("userId") Integer userId);
	
	@Query("select u.mobileNo from UserProfile u where u.userId in :userId")
	Long getUserMobileNum(@Param("userId") Integer userId);
	
	@Query(value="select u.email from user_profile u where u.email = :email",nativeQuery=true)
	public String findEmail(@Param ("email") String emailid);
	
	@Query("select u.userName from UserProfile u where u.userId=:userId")
	String getUserName1(@Param("userId") Integer userId);

}
