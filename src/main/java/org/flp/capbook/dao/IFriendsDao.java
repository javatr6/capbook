package org.flp.capbook.dao;

import javax.transaction.Transactional;

import org.flp.capbook.model.FriendsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository("friendsDao")
@Transactional

public interface IFriendsDao extends JpaRepository<FriendsList, Integer>{

}
