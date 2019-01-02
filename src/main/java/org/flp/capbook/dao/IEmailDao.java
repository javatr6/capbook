package org.flp.capbook.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.flp.capbook.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("emaildao")
@Transactional
public interface IEmailDao extends JpaRepository<Email, Integer> {
	
	@Query("select e from Email e where e.toAddress =:emailId")
	public List<Email> getAllEmailsOfUser(@Param("emailId") String  emailId);


}
