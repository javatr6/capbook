package org.flp.capbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = {
	    @UniqueConstraint(columnNames = { "groupName" }) })
public class Groups {
    
	@Id
	@GeneratedValue
	private Integer groupId;
	@NotNull
	@Column(unique=true)
	private String groupName;
	private Integer groupAdmin;
	private String description;
	/*@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="group_albums",
	joinColumns= {@JoinColumn(name="groupId")},
	inverseJoinColumns= {@JoinColumn(name="albumId")})
	private List<Albums> albums= new ArrayList<>();;
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
	}*/
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
	public Integer getGroupAdmin() {
		return groupAdmin;
	}
	public void setGroupAdmin(Integer groupAdmin) {
		this.groupAdmin = groupAdmin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Groups(Integer groupId, String groupName, Integer groupAdmin, String description) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupAdmin = groupAdmin;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", groupName=" + groupName + ", groupAdmin=" + groupAdmin
				+ ", description=" + description + "]";
	}
	public Groups() {
		super();
	}
	
	
	
	
	
}
