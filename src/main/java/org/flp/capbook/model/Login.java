package org.flp.capbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Login {

@Id	
private String email;
private String password;
private String status;
private String activationURL;
private String activeStatus;

public Login(){
	
}

public Login(String email, String password, String status, String activationURL, String activeStatus) {
	super();
	this.email = email;
	this.password = password;
	this.status = status;
	this.activationURL = activationURL;
	this.activeStatus = activeStatus;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getActivationURL() {
	return activationURL;
}

public void setActivationURL(String activationURL) {
	this.activationURL = activationURL;
}

public String getActiveStatus() {
	return activeStatus;
}

public void setActiveStatus(String activeStatus) {
	this.activeStatus = activeStatus;
}

@Override
public String toString() {
	return "Login [email=" + email + ", password=" + password + ", status=" + status + ", activationURL="
			+ activationURL + ", activeStatus=" + activeStatus + "]";
}




	
	
	
}
