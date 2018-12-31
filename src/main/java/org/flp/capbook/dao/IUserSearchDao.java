package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository("userSearchDao")
public interface IUserSearchDao extends JpaRepository<UserProfile,Integer>{
	
	@Query("select u.userName from UserProfile u where u.userName like :username%")
	List<String> getUserName(@Param("username") String username);

}
