package org.flp.capbook.model;


import java.io.File;
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
import javax.persistence.Transient;

@Entity
public class Status {
		@Id
		@GeneratedValue
		private Integer status_id;
		private String text;
		private String imageUrl;
		//private Integer comment_id;
		private  Integer user_id;
		
		@Transient
		private File file;
		@OneToMany(mappedBy="status",targetEntity=Comments.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
		private List<Comments> comments=new ArrayList<>();		

		@ManyToOne
		@JoinColumn(name="statusfk")
		private UserProfile user;
		
		public Status() {
			super();
			
		}

		public Status(Integer status_id, String text, String imageUrl, Integer user_id, File file,
				List<Comments> comments, UserProfile user) {
			super();
			this.status_id = status_id;
			this.text = text;
			this.imageUrl = imageUrl;
			this.user_id = user_id;
			this.file = file;
			this.comments = comments;
			this.user = user;
		}

		public Status(Integer status_id, String text, Integer user_id, File file, List<Comments> comments,
				UserProfile user) {
			super();
			this.status_id = status_id;
			this.text = text;
			this.user_id = user_id;
			this.file = file;
			this.comments = comments;
			this.user = user;
		}

		public Integer getStatus_id() {
			return status_id;
		}

		public void setStatus_id(Integer status_id) {
			this.status_id = status_id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public Integer getUser_id() {
			return user_id;
		}

		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
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

		@Override
		public String toString() {
			return "Status [status_id=" + status_id + ", text=" + text + ", imageUrl=" + imageUrl + ", user_id="
					+ user_id + ", file=" + file + ", comments=" + comments + ", user=" + user + "]";
		}
		
}