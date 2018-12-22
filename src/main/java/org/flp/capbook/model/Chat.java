package org.flp.capbook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Chat {

	@Id
	@GeneratedValue
	private Long chat_Id;
	private Integer user_Sender_Id;
	private Integer user_Receiver_Id;
	
	/*@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="chat_message", 
	joinColumns= {@JoinColumn(name="custId")},
	inverseJoinColumns= {@JoinColumn(name="productId")})
	@JsonBackReference
	@JsonIgnoreProperties("customers")*/
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="chat_message",
	joinColumns= {@JoinColumn(name="chat_Id")},
	inverseJoinColumns={@JoinColumn(name="message_Id")})
	private List<Message> messages;
	
	@ManyToOne
	@JoinColumn(name="chatfk")
	private UserProfile user;

	public Chat(Long chat_Id, Integer user_Sender_Id, Integer user_Receiver_Id) {
		super();
		this.chat_Id = chat_Id;
		this.user_Sender_Id = user_Sender_Id;
		this.user_Receiver_Id = user_Receiver_Id;
	}

	public Long getChat_Id() {
		return chat_Id;
	}

	public void setChat_Id(Long chat_Id) {
		this.chat_Id = chat_Id;
	}

	public Integer getUser_Sender_Id() {
		return user_Sender_Id;
	}

	public void setUser_Sender_Id(Integer user_Sender_Id) {
		this.user_Sender_Id = user_Sender_Id;
	}

	public Integer getUser_Receiver_Id() {
		return user_Receiver_Id;
	}

	public void setUser_Receiver_Id(Integer user_Receiver_Id) {
		this.user_Receiver_Id = user_Receiver_Id;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Chat [chat_Id=" + chat_Id + ", user_Sender_Id=" + user_Sender_Id + ", user_Receiver_Id="
				+ user_Receiver_Id + ", messages=" + messages + "]";
	}
}
