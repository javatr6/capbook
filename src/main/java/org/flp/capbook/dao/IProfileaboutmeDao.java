package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("profileaboutmeDao")
@Transactional
public interface IProfileaboutmeDao extends JpaRepository<UserProfile, Integer> {
	
	
	@Query("from UserProfile u where u.userId= :id")
	public UserProfile getAllDetails(@Param("id")Integer id);
}
