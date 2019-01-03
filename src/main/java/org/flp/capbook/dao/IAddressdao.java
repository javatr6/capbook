package org.flp.capbook.dao;

import java.sql.Date;

import org.springframework.transaction.annotation.Transactional;

import org.flp.capbook.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
@Transactional
public interface IAddressdao extends JpaRepository<Address, Integer>{

	@Query("from Address a where a.userId = :id")
	Address getByUser(@Param("id")Integer userid);
	
	@Modifying
	@Query(value="update user_profile set dob=:dob ,mobile_no=:mobile_no,visibility=:visibility where user_id=:user_id",nativeQuery=true)
	Integer update(@Param("dob") Date dob,@Param("mobile_no")Long Mobile,@Param("visibility")Boolean visibility,@Param("user_id")Integer userid);
	
	
/*  @Query("select email from UserProfile where email:email") 	
   public String findByEmail(@PathParam("email") String email);
  
 @Query("insert into Address(user) values(user:user)")
 public Integer saveUserId(@PathParam("user") Integer userId);*/
	
	
	
} 