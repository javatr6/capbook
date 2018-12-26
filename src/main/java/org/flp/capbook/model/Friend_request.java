package org.flp.capbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Friend_request {
	
	@Id
	private Integer friendId;
	private Integer senderId;
	private Integer receiverId;
	private String status="pending";
	
	
	public Friend_request() {
		
	}


	public Friend_request(Integer friendId, Integer senderId, Integer receiverId, String status) {
		super();
		this.friendId = friendId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = status;
	}


	public Integer getFriendId() {
		return friendId;
	}


	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}


	public Integer getSenderId() {
		return senderId;
	}


	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}


	public Integer getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Friend_request [friendId=" + friendId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", status=" + status + "]";
	}

	

}