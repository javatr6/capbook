package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Transactional
@Repository("searchDao")
public interface ISearchDao extends JpaRepository<Groups,Integer> {
	
	@Query("select g.groupName from Groups g where g.groupName like :letter%")
	public List<String> getGroupNames(@Param("letter") String letter) ;
	
	
	

}
