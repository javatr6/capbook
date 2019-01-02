package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("addressDao")
@Transactional
public interface IAddressdao extends JpaRepository<Address, Integer>{

	@Query("from Address a where a.userId = :id")
	Address getByUser(@Param("id")Integer userid);
	
/*  @Query("select email from UserProfile where email:email") 	
   public String findByEmail(@PathParam("email") String email);
  
 @Query("insert into Address(user) values(user:user)")
 public Integer saveUserId(@PathParam("user") Integer userId);*/
	
	
	
}
