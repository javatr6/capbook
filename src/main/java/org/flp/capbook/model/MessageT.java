package org.flp.capbook.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class MessageT {

	@Id
	@GeneratedValue
	private Integer message_Id;
	private String text;
	private LocalDateTime date=LocalDateTime.now();
	@ManyToMany(mappedBy="messages")
	@JsonIgnoreProperties("messages")
	private List<Chat> chats;
	
	public MessageT() {
		super();
	}
	
	public MessageT(Integer message_Id, String text, LocalDateTime date) {
		super();
		this.message_Id = message_Id;
		this.text = text;
		this.date = date;
	}
	
	public MessageT(String text, LocalDateTime date, List<Chat> chats) {
		super();
		this.text = text;
		this.date = date;
		this.chats = chats;
	}
	
	public MessageT(Integer message_Id, String text, LocalDateTime date, List<Chat> chats) {
		super();
		this.message_Id = message_Id;
		this.text = text;
		this.date = date;
		this.chats = chats;
	}

	

	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	public Integer getMessage_Id() {
		return message_Id;
	}
	public void setMessage_Id(Integer message_Id) {
		this.message_Id = message_Id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	/*@Override
	public String toString() {
		return "Message [message_Id=" + message_Id + ", text=" + text + ", date=" + date + ", chats=" + chats + "]";
	}
	
	*/
}
