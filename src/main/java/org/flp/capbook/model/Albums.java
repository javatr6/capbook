package org.flp.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Albums {

	
	@Id
	@GeneratedValue
	private String albumId;
	private String albumName;
	private String description;
	@ManyToOne
	@JoinColumn(name="albumfk")
	private UserProfile user;
	
	public Albums() {
		
	}

	public Albums(String albumId, String albumName, String description) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.description = description;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Albums [albumId=" + albumId + ", albumName=" + albumName + ", description=" + description + "]";
	}

	
	
	
}
