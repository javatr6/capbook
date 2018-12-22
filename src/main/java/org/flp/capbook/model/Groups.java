package org.flp.capbook.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Groups {
    
	@Id
	@GeneratedValue
	private Integer groupId;
	private String groupName;
	private String groupAdmin;
	private String description;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="group_albums",
	joinColumns= {@JoinColumn(name="groupId")},
	inverseJoinColumns= {@JoinColumn(name="albumId")})
	private List<Albums> albums= new ArrayList<>();
	@ManyToMany
	@JoinTable(name="event_delegate",joinColumns= {@JoinColumn(name="groups")},inverseJoinColumns= {@JoinColumn(name="user")})
	private List<UserProfile> user;
	
	public Groups(Integer groupId, String groupName, String groupAdmin, String description, List<Albums> albums) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupAdmin = groupAdmin;
		this.description = description;
		this.albums = albums;
	}
	public Groups() {
		super();
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupAdmin() {
		return groupAdmin;
	}
	public void setGroupAdmin(String groupAdmin) {
		this.groupAdmin = groupAdmin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Albums> getAlbums() {
		return albums;
	}
	public void setAlbums(List<Albums> albums) {
		this.albums = albums;
	}
	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", groupName=" + groupName + ", groupAdmin=" + groupAdmin
				+ ", description=" + description + ", albums=" + albums + "]";
	}
	
	
	
	
}
