package org.flp.capbook.dao;

import java.util.List;

import org.flp.capbook.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("messageDao")
@Transactional
public interface IMessageDao extends JpaRepository<Message,Integer> {

	@Query("select m from Message m where m.mobileNumber=:mobileNum")
	List<Message> getAllMessages(@Param("mobileNum") Long mobileNum);
	
	
	
	

}
