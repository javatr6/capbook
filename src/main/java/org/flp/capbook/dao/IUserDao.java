package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userDao")
@Transactional
public interface IUserDao extends JpaRepository<UserProfile, Integer>{

	@Query("from UserProfile u where u.email= :email")
	UserProfile searchUser(@Param("email") String email);

	@Query("from UserProfile u where u.userName=:uName")
	UserProfile findByName(@Param("uName")String uName);

	@Query("select u.email from UserProfile u where u.userId=:userId")
	public String getMail(@Param("userId") Integer userId);

	@Query("select u.email from UserProfile u where u.userId in :id")
	List<String> getEmail(@Param("id")List<Integer> ids);
	
	@Query("From UserProfile u where u.userName =:input")
	public List<UserProfile> searchFriend(@Param ("input") String input);

}