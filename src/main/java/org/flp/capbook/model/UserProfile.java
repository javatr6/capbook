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
	private Boolean isPrivateDob;
	private Date dob;
	private Boolean isPrivateAreaofIntrest;
	private String areaofInterest;
	@OneToMany(mappedBy="user",targetEntity=Images.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Images> images=new ArrayList<Images>();
	private Boolean isPrivategender;
	private String gender;
	private Long mobileNo;
	private Boolean isPrivateMobileNo;
	@ManyToMany
	@JoinTable(name="user_status",joinColumns= {@JoinColumn(name="user")},inverseJoinColumns= {@JoinColumn(name="groups")})
	private List<Groups> groups;
	
	@OneToMany(mappedBy="user",targetEntity=Status.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Status> status;
	
	@OneToMany(mappedBy="user",targetEntity=Chat.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Chat> chat;
	@Column(unique=true)
	private String email;
	private Boolean isPrivateEmail;
	
	public UserProfile() {
		
	}

	public UserProfile(Integer userId, String userName, Address address, Boolean isPrivateDob, Date dob,
			Boolean isPrivateAreaofIntrest, String areaofInterest, List<Images> images, Boolean isPrivategender,
			String gender, Long mobileNo, Boolean isPrivateMobileNo, List<Groups> groups, List<Status> status,
			List<Chat> chat, String email, Boolean isPrivateEmail) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.isPrivateDob = isPrivateDob;
		this.dob = dob;
		this.isPrivateAreaofIntrest = isPrivateAreaofIntrest;
		this.areaofInterest = areaofInterest;
		this.images = images;
		this.isPrivategender = isPrivategender;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.isPrivateMobileNo = isPrivateMobileNo;
		this.groups = groups;
		this.status = status;
		this.chat = chat;
		this.email = email;
		this.isPrivateEmail = isPrivateEmail;
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

	public Boolean getIsPrivateDob() {
		return isPrivateDob;
	}

	public void setIsPrivateDob(Boolean isPrivateDob) {
		this.isPrivateDob = isPrivateDob;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getIsPrivateAreaofIntrest() {
		return isPrivateAreaofIntrest;
	}

	public void setIsPrivateAreaofIntrest(Boolean isPrivateAreaofIntrest) {
		this.isPrivateAreaofIntrest = isPrivateAreaofIntrest;
	}

	public String getAreaofInterest() {
		return areaofInterest;
	}

	public void setAreaofInterest(String areaofInterest) {
		this.areaofInterest = areaofInterest;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public Boolean getIsPrivategender() {
		return isPrivategender;
	}

	public void setIsPrivategender(Boolean isPrivategender) {
		this.isPrivategender = isPrivategender;
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

	public Boolean getIsPrivateMobileNo() {
		return isPrivateMobileNo;
	}

	public void setIsPrivateMobileNo(Boolean isPrivateMobileNo) {
		this.isPrivateMobileNo = isPrivateMobileNo;
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

	public Boolean getIsPrivateEmail() {
		return isPrivateEmail;
	}

	public void setIsPrivateEmail(Boolean isPrivateEmail) {
		this.isPrivateEmail = isPrivateEmail;
	}

	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", userName=" + userName + ", address=" + address + ", isPrivateDob="
				+ isPrivateDob + ", dob=" + dob + ", isPrivateAreaofIntrest=" + isPrivateAreaofIntrest
				+ ", areaofInterest=" + areaofInterest + ", images=" + images + ", isPrivategender=" + isPrivategender
				+ ", gender=" + gender + ", mobileNo=" + mobileNo + ", isPrivateMobileNo=" + isPrivateMobileNo
				+ ", groups=" + groups + ", status=" + status + ", chat=" + chat + ", email=" + email
				+ ", isPrivateEmail=" + isPrivateEmail + "]";
	}
	
	
}
