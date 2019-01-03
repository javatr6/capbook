package org.flp.capbook.dao;


import java.util.List;

import org.flp.capbook.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("chatDao")
public interface IChatDao extends JpaRepository<Chat, Long>{

	@Query("from Chat where user_id=:user_Sender_Id and user_Receiver_Id=:user_Receiver_Id")
	public Chat VerifyingChat(@Param("user_Sender_Id") Integer user_Sender_Id,@Param("user_Receiver_Id") Integer user_Receiver_Id);
	@Query("from Chat where chat_id=:chat_id")
	public List<Chat> findByChatId(@Param("chat_id")Long chat_Id);
}
