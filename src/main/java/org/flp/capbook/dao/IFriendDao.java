package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.Friend_request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("frienddao")
@Transactional
public interface IFriendDao extends JpaRepository<Friend_request,Integer>{
	
	
	

}
