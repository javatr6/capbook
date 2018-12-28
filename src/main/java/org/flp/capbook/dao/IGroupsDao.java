package org.flp.capbook.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository("groupsDao")
@Transactional
public interface IGroupsDao extends JpaRepository<Groups, Integer>{

	@Query("from Groups g where g.groupAdmin=:input")
	public List<Groups> findGroups(@Param("input") Integer input);

	@Query("from Groups g where g.groupId in(select r.groupId from Group_Request r where r.userId=:input)")
	public List<Groups> findGroupsuser(@Param("input")Integer input);
	

}

