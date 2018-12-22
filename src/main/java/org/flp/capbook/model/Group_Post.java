package org.flp.capbook.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Group_Post {
	
	
	@Id
	@GeneratedValue
	private Integer postId;
	private String postMessage;
	private Integer imageId;
	private Integer userId;
	private Integer groupId;
	@OneToMany(mappedBy="postId",targetEntity=Group_Comments.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Group_Comments> group_comments = new ArrayList<>();
	
	public Group_Post() {
		super();
	}

	public Group_Post(Integer postId, String postMessage, Integer imageId, Integer userId, Integer groupId,
			List<Group_Comments> group_comments) {
		super();
		this.postId = postId;
		this.postMessage = postMessage;
		this.imageId = imageId;
		this.userId = userId;
		this.groupId = groupId;
		this.group_comments = group_comments;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostMessage() {
		return postMessage;
	}

	public void setPostMessage(String postMessage) {
		this.postMessage = postMessage;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public List<Group_Comments> getGroup_comments() {
		return group_comments;
	}

	public void setGroup_comments(List<Group_Comments> group_comments) {
		this.group_comments = group_comments;
	}

	@Override
	public String toString() {
		return "Group_Post [postId=" + postId + ", postMessage=" + postMessage + ", imageId=" + imageId + ", userId="
				+ userId + ", groupId=" + groupId + ", group_comments=" + group_comments + "]";
	}
	
}
