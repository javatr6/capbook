package org.flp.capbook.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Group_Comments {
	
	@Id
	@GeneratedValue
	private Integer groupCommentId;
	@ManyToOne
	@JoinColumn(name="PostFk")
	private Group_Post postId;
	@ManyToOne
	@JoinColumn(name="TopicFk")
	private Group_Topic topicId;
	private String commentText;
	private LocalDate postedDate;
	private Integer commented_by;
	public Group_Comments() {
		super();
	}
	public Group_Comments(Integer groupCommentId, Group_Post postId, Group_Topic topicId, String commentText,
			LocalDate postedDate, Integer commented_by) {
		super();
		this.groupCommentId = groupCommentId;
		this.postId = postId;
		this.topicId = topicId;
		this.commentText = commentText;
		this.postedDate = postedDate;
		this.commented_by = commented_by;
	}
	public Integer getGroupCommentId() {
		return groupCommentId;
	}
	public void setGroupCommentId(Integer groupCommentId) {
		this.groupCommentId = groupCommentId;
	}
	public Group_Post getPostId() {
		return postId;
	}
	public void setPostId(Group_Post postId) {
		this.postId = postId;
	}
	public Group_Topic getTopicId() {
		return topicId;
	}
	public void setTopicId(Group_Topic topicId) {
		this.topicId = topicId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public LocalDate getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	public Integer getCommented_by() {
		return commented_by;
	}
	public void setCommented_by(Integer commented_by) {
		this.commented_by = commented_by;
	}
	@Override
	public String toString() {
		return "Group_Comments [groupCommentId=" + groupCommentId + ", postId=" + postId + ", topicId=" + topicId
				+ ", commentText=" + commentText + ", postedDate=" + postedDate + ", commented_by=" + commented_by
				+ "]";
	}
	
	

}
