package org.flp.capbook.model;



	
	
		import java.sql.Date;

		import javax.persistence.Entity;
		import javax.persistence.GeneratedValue;
		import javax.persistence.Id;

		@Entity
		public class Email {
			
			@Id
			@GeneratedValue
			private int id;
			private String fromAddress;
			private String toAddress;
			private String subject;
			private String messageBody;
			private Date date;
			public Email() {
				super();
			}
			public Email(int id, String fromAddress, String toAddress, String subject, String messageBody, Date date) {
				super();
				this.id = id;
				this.fromAddress = fromAddress;
				this.toAddress = toAddress;
				this.subject = subject;
				this.messageBody = messageBody;
				this.date = date;
			}
			public int getId() {
				return id;
			}
			public void setId(int id) {
				this.id = id;
			}
			public String getFromAddress() {
				return fromAddress;
			}
			public void setFromAddress(String fromAddress) {
				this.fromAddress = fromAddress;
			}
			public String getToAddress() {
				return toAddress;
			}
			public void setToAddress(String toAddress) {
				this.toAddress = toAddress;
			}
			public String getSubject() {
				return subject;
			}
			public void setSubject(String subject) {
				this.subject = subject;
			}
			public String getMessageBody() {
				return messageBody;
			}
			public void setMessageBody(String messageBody) {
				this.messageBody = messageBody;
			}
			public Date getDate() {
				return date;
			}
			public void setDate(Date date) {
				this.date = date;
			}
			@Override
			public String toString() {
				return "Email [id=" + id + ", fromAddress=" + fromAddress + ", toAddress=" + toAddress + ", subject=" + subject
						+ ", messageBody=" + messageBody + ", date=" + date + "]";
			}
			
			
			

		} 

	

