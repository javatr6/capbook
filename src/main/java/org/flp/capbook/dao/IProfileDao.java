package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("profiledao")
@Transactional
public interface IProfileDao extends JpaRepository<Images, Integer> {

	
	@Query("select i.imageUrl from Images i where i.userId = :id and albumName = :location")
	List<String> getImage(@Param("id")Integer userId,@Param("location") String location);

	
	@Query("select i.imageUrl from Images i where i.userId = :id and albumName = 'profile' and i.imageId = :maxId")
	List<String> getProfilePic(@Param("id")Integer userId,@Param("maxId") Integer maxId);

	@Query("select max(i.imageId) from Images i where  i.userId = :id ")
	Integer getMaxId(@Param("id")Integer userId);


	
}
