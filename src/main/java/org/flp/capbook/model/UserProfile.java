package org.flp.capbook.model;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserProfile {
  
	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	@OneToOne
	@JoinColumn(name="Addressfk")
	private Address address;
	private Date dob;
	
	@OneToMany(mappedBy="userId",targetEntity=Images.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Images> images=new ArrayList<Images>();
	private String gender;
	private Long mobileNo;
	@ManyToMany
	@JoinTable(name="user_status",joinColumns= {@JoinColumn(name="user")},inverseJoinColumns= {@JoinColumn(name="groups")})
	private List<Groups> groups;
	
	@OneToMany(mappedBy="user",targetEntity=Status.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Status> status;
	
	@OneToMany(mappedBy="user",targetEntity=Chat.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Chat> chat;
	@Column(unique=true)
	private String email;
	
	private Boolean visibility = true;
	
	
	public UserProfile() {
		
	}


	public UserProfile(Integer userId, String userName, Address address, Date dob, List<Images> images, String gender,
			Long mobileNo, List<Groups> groups, List<Status> status, List<Chat> chat, String email,
			Boolean visibility) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.dob = dob;
		this.images = images;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.groups = groups;
		this.status = status;
		this.chat = chat;
		this.email = email;
		this.visibility = visibility;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public List<Images> getImages() {
		return images;
	}


	public void setImages(List<Images> images) {
		this.images = images;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public List<Groups> getGroups() {
		return groups;
	}


	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}


	public List<Status> getStatus() {
		return status;
	}


	public void setStatus(List<Status> status) {
		this.status = status;
	}


	public List<Chat> getChat() {
		return chat;
	}


	public void setChat(List<Chat> chat) {
		this.chat = chat;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getVisibility() {
		return visibility;
	}


	public void setVisibility(Boolean visibility) {
		this.visibility = visibility;
	}


	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", userName=" + userName + ", address=" + address + ", dob=" + dob
				+ ", images=" + images + ", gender=" + gender + ", mobileNo=" + mobileNo + ", groups=" + groups
				+ ", status=" + status + ", chat=" + chat + ", email=" + email + ", visibility=" + visibility + "]";
	}
	
}