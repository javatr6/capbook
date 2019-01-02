package org.flp.capbook.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Status {
		@Id
		@GeneratedValue
		private Integer status_id;
		private String statusText;

		//private Integer comment_id;
		//private  Integer user_id;
		private String userName;
		
		@OneToMany(mappedBy="status",targetEntity=Comments.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
		@JsonIgnoreProperties("status")
		private List<Comments> comments;
		
		@OneToMany(mappedBy="status",targetEntity=Likes.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
		@JsonIgnoreProperties("status")
		private List<Likes> likes;	

		@ManyToOne
		@JoinColumn(name="userId")
		@JsonIgnoreProperties("status")
		private UserProfile user;
		
		

		

		
		public Status() {
			super();
			
		}

		
		


		





		public Status(Integer status_id, String statusText) {
			super();
			this.status_id = status_id;
			this.statusText = statusText;
		}











		public Status(Integer status_id, String statusText, String userName, List<Comments> comments, List<Likes> likes,
				UserProfile user) {
			super();
			this.status_id = status_id;
			this.statusText = statusText;
			this.userName = userName;
			this.comments = comments;
			this.likes = likes;
			this.user = user;
		}











		public Status(Integer status_id, String statusText, String userName) {
			super();
			this.status_id = status_id;
			this.statusText = statusText;
			this.userName = userName;
		}





		public Status(Integer status_id, String statusText, String userName, UserProfile user) {
			super();
			this.status_id = status_id;
			this.statusText = statusText;
			this.userName = userName;
			this.user = user;
		}





		public Status(Integer status_id, String statusText, String userName, List<Comments> comments) {
			super();
			this.status_id = status_id;
			this.statusText = statusText;
			this.userName = userName;
			this.comments = comments;
		}





		public Status(Integer status_id, String statusText, List<Comments> comments, UserProfile user,
				String userName) {
			super();
			this.status_id = status_id;
			this.statusText = statusText;
			this.comments = comments;
			this.user = user;
			this.userName = userName;
		}



		public Integer getStatus_id() {
			return status_id;
		}



		public void setStatus_id(Integer status_id) {
			this.status_id = status_id;
		}



		public String getStatusText() {
			return statusText;
		}


		public List<Likes> getLikes() {
			return likes;
		}





		public void setLikes(List<Likes> likes) {
			this.likes = likes;
		}
		public void setStatusText(String statusText) {
			this.statusText = statusText;
		}



		public List<Comments> getComments() {
			return comments;
		}



		public void setComments(List<Comments> comments) {
			this.comments = comments;
		}



		public UserProfile getUser() {
			return user;
		}



		public void setUser(UserProfile user) {
			this.user = user;
		}



		public String getUserName() {
			return userName;
		}



		public void setUserName(String userName) {
			this.userName = userName;
		}



		@Override
		public String toString() {
			return "Status [status_id=" + status_id + ", statusText=" + statusText + ", comments=" + comments
					+ ", user=" + user + ", userName=" + userName + "]";
		}
		
	


		
}