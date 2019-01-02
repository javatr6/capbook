package org.flp.capbook.model;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer"})
public class Comments {
	@Id
	@GeneratedValue
	private Integer commentId;
	private String commentText;
	private Integer postedBy;
	private Integer postedTo;
	private LocalDateTime dateOfPosting=LocalDateTime.now();
	//private Integer statusId;
	private Integer likeCount;
	private Integer dislikeCount;
	@ManyToOne
	@JoinColumn(name="status_id")
	@JsonIgnoreProperties("comments")
	//@JsonBackReference
	private Status status;
	
	
	
	public Comments() {
		super();
	}

	/*public Comments(Long commentId, String commentText, Long postedBy, Long postedTo, LocalDate dateOfPosting, Long statusId,
			Long likeCount, Long dislikeCount) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.postedBy = postedBy;
		this.postedTo = postedTo;
		this.dateOfPosting = dateOfPosting;
		this.statusId = statusId;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
	}*/

	public Integer getCommentId() {
		return commentId;
	}

	
	public Comments(Integer commentId, String commentText, Integer postedBy, Integer postedTo, Integer statusId, Integer likeCount,
			Integer dislikeCount) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.postedBy = postedBy;
		this.postedTo = postedTo;
		//this.statusId = statusId;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
	}
	

	public Comments(Integer commentId, String commentText, Integer postedBy, Integer postedTo, LocalDateTime dateOfPosting,
			Integer likeCount, Integer dislikeCount, Status status) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
		this.postedBy = postedBy;
		this.postedTo = postedTo;
		this.dateOfPosting = dateOfPosting;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.status = status;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Integer getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Integer postedBy) {
		this.postedBy = postedBy;
	}

	public Integer getPostedTo() {
		return postedTo;
	}

	public void setPostedTo(Integer postedTo) {
		this.postedTo = postedTo;
	}

	
	public LocalDateTime getDateOfPosting() {
		return dateOfPosting;
	}

	public void setDateOfPosting(LocalDateTime dateOfPosting) {
		this.dateOfPosting = dateOfPosting;
	}

	/*public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}*/

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public Integer getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(Integer dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", commentText=" + commentText + ", postedBy=" + postedBy
				+ ", postedTo=" + postedTo + ", dateOfPosting=" + dateOfPosting + ", likeCount=" + likeCount
				+ ", dislikeCount=" + dislikeCount + ", status=" + status + "]";
	}

	/*@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", commentText=" + commentText + ", postedBy=" + postedBy
				+ ", postedTo=" + postedTo + ", dateOfPosting=" + dateOfPosting + ", statusId=" + statusId
				+ ", likeCount=" + likeCount + ", dislikeCount=" + dislikeCount + "]";
	}*/
	

	
	
	
	

}
