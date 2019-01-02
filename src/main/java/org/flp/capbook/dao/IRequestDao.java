package org.flp.capbook.dao;
import javax.transaction.Transactional;

import org.flp.capbook.model.Group_Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository("requestDao")
@Transactional

public interface IRequestDao extends JpaRepository<Group_Request, Integer>{
	
	@Query("select g_requestId from Group_Request where userId=:Id")
	Integer getRequestId(@Param("Id") Integer Id);

}

