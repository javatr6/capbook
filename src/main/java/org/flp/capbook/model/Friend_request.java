package org.flp.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Friend_request {
	
	@Id
	@GeneratedValue
	private Integer requestId;
	private Integer senderId;
	private Integer receiverId;
	private String status="pending";
	
	
	public Friend_request() {
		
	}



	public Friend_request(Integer requestId, Integer senderId, Integer receiverId, String status) {
		super();
		this.requestId = requestId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.status = status;
	}



	public Integer getRequestId() {
		return requestId;
	}



	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
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
		return "Friend_request [requestId=" + requestId + ", senderId=" + senderId + ", receiverId=" + receiverId
				+ ", status=" + status + "]";
	}


}