package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("loginDao")
@Transactional
public interface ILoginDao extends JpaRepository<Login, String>{
	
	 @Query("from Login  where mail=:email ")
	    public Login findByUsername(@Param("email") String email);
	 
	 @Query("select l.password from Login l where l.email=:email")
	 public String getPsswdBymail(@Param("email")String Email);
	 
	 @Modifying
	 @Query("update Login set password=:psswd where email=:emailId")
	 public Integer saveLgnPasswd(@Param("psswd")String password,@Param("emailId")String email);

}
