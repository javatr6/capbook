package org.flp.capbook.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Likes {

	@Id
	@GeneratedValue
	private Integer like_Id;
	private Integer liked_By;
	private LocalDateTime date_of_Like;
	private boolean like_count;
	private boolean dislike_count;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	@JsonIgnoreProperties("likes")
	//@JsonBackReference
	private Status status;

	
	public Likes() {
		super();
	}


	public Likes(Integer like_Id, Integer liked_By, LocalDateTime date_of_Like, boolean like_count,
			boolean dislike_count, Status status) {
		super();
		this.like_Id = like_Id;
		this.liked_By = liked_By;
		this.date_of_Like = date_of_Like;
		this.like_count = like_count;
		this.dislike_count = dislike_count;
		this.status = status;
	}


	public Integer getLike_Id() {
		return like_Id;
	}


	public void setLike_Id(Integer like_Id) {
		this.like_Id = like_Id;
	}


	public Integer getLiked_By() {
		return liked_By;
	}


	public void setLiked_By(Integer liked_By) {
		this.liked_By = liked_By;
	}


	public LocalDateTime getDate_of_Like() {
		return date_of_Like;
	}


	public void setDate_of_Like(LocalDateTime date_of_Like) {
		this.date_of_Like = date_of_Like;
	}


	public boolean getLike_count() {
		return like_count;
	}


	public void setLike_count(boolean like_count) {
		this.like_count = like_count;
	}


	public boolean getDislike_count() {
		return dislike_count;
	}


	public void setDislike_count(boolean dislike_count) {
		this.dislike_count = dislike_count;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}

	
}