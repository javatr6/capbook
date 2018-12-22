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

@Entity
public class Status {
		@Id
		@GeneratedValue
		private Integer status_id;
		private String text;
		private byte[] image;
		//private Integer comment_id;
		private  Integer user_id;
		@OneToMany(mappedBy="status",targetEntity=Comments.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
		private List<Comments> comments=new ArrayList<>();		

		@ManyToOne
		@JoinColumn(name="statusfk")
		private UserProfile user;
		
		public Status() {
			super();
			
		}


		public Status(Integer status_id, String text, byte[] image, Integer comment_id, Integer user_id) {
			super();
			this.status_id = status_id;
			this.text = text;
			this.image = image;
			//this.comment_id = comment_id;
			this.user_id = user_id;
		}
		

		public Status(Integer status_id, String text, byte[] image, Integer comment_id, Integer user_id,
				List<Comments> comments) {
			super();
			this.status_id = status_id;
			this.text = text;
			this.image = image;
			//this.comment_id = comment_id;
			this.user_id = user_id;
			this.comments = comments;
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


		public byte[] getImage() {
			return image;
		}


		public void setImage(byte[] image) {
			this.image = image;
		}


		/*public Integer getComment_id() {
			return comment_id;
		}


		public void setComment_id(Integer comment_id) {
			this.comment_id = comment_id;
		}*/


		public Integer getUser_id() {
			return user_id;
		}


		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}

		
		
		public List<Comments> getComments() {
			return comments;
		}


		public void setComments(List<Comments> comments) {
			this.comments = comments;
		}


		@Override
		public String toString() {
			return "Status [status_id=" + status_id + ", text=" + text + ", image=" + Arrays.toString(image)
					+ ", user_id=" + user_id + ", comments=" + comments + "]";
		}

}