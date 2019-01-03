package org.flp.capbook.dao;

import org.flp.capbook.model.MessageT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("msgDao")
public interface IMsgDao extends JpaRepository<MessageT, Integer>{

	

}
