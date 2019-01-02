package org.flp.capbook.model;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="SMS")
public class Message {

	@Id
	@GeneratedValue
	private int msgId;
	private String msgBody;
	private Date ReceivedDate;
	private String userName;
	private Long mobileNumber;
	
	
	
	public Message() {
		super();
	}



	public Message(int msgId, String msgBody, Date receivedDate, String userName, Long mobileNumber) {
		super();
		this.msgId = msgId;
		this.msgBody = msgBody;
		ReceivedDate = receivedDate;
		this.userName = userName;
		this.mobileNumber = mobileNumber;
	}



	public int getMsgId() {
		return msgId;
	}



	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}



	public String getMsgBody() {
		return msgBody;
	}



	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}



	public Date getReceivedDate() {
		return ReceivedDate;
	}



	public void setReceivedDate(Date receivedDate) {
		ReceivedDate = receivedDate;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public Long getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", msgBody=" + msgBody + ", ReceivedDate=" + ReceivedDate + ", userName="
				+ userName + ", mobileNumber=" + mobileNumber + "]";
	}
	

	
	
}
