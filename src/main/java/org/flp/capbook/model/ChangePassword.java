package org.flp.capbook.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChangePassword {
	@Id
	private String emailId;
	private String oldPassword;
	private String newPassword;
 
	public ChangePassword() {
		
	}
	
	public ChangePassword(String emailId, String oldPassword, String newPassword) {
	super();
	this.emailId = emailId;
	this.oldPassword = oldPassword;
	this.newPassword = newPassword;
}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "CapBook [emailId=" + emailId + ", oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	};

}  
