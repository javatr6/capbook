package org.flp.capbook.model;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;                                                                                 
                                                                                                                    
@Entity                                                                                                             
public class Images {                                                                                               
                                                                                                                    
	@Id                                                                                                             
	@GeneratedValue                                                                                                 
	private Integer imageId;                                                                                        
	private String postDisc;                                                                                        
	private String imageUrl;                                                                                        
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserProfile user;
	private String albumName;
	@Transient                                                                                                      
	private File file;
	public Images() {
		
	}
	public Images(Integer imageId, String postDisc, String imageUrl, UserProfile user, String albumName, File file) {
		super();
		this.imageId = imageId;
		this.postDisc = postDisc;
		this.imageUrl = imageUrl;
		this.user = user;
		this.albumName = albumName;
		this.file = file;
	}
	public Integer getImageId() {
		return imageId;
	}
	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}
	public String getPostDisc() {
		return postDisc;
	}
	public void setPostDisc(String postDisc) {
		this.postDisc = postDisc;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Images [imageId=" + imageId + ", postDisc=" + postDisc + ", imageUrl=" + imageUrl + ", user=" + user
				+ ", albumName=" + albumName + ", file=" + file + "]";
	}
		               
}