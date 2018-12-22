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

	private String toMobileNumber;
	
	
	
	public Message() {
		super();
	}
	
	
	public Message(int msgId, String msgBody, Date receivedDate, String toMobileNumber) {
		super();
		this.msgId = msgId;
		this.msgBody = msgBody;
		ReceivedDate = receivedDate;
	
		this.toMobileNumber = toMobileNumber;
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
	
	public String getToMobileNumber() {
		return toMobileNumber;
	}
	public void setToMobileNumber(String toMobileNumber) {
		this.toMobileNumber = toMobileNumber;
	}
	
	
}
