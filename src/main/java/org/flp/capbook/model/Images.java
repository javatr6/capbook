package org.flp.capbook.model;

import java.io.File;                                                                                                


import javax.persistence.Entity;                                                                                    
import javax.persistence.GeneratedValue;                                                                            
import javax.persistence.Id;                                                                                        
import javax.persistence.Transient;                                                                                 
                                                                                                                    
@Entity                                                                                                             
public class Images {                                                                                               
                                                                                                                    
	@Id                                                                                                             
	@GeneratedValue                                                                                                 
	private Integer imageId;                                                                                        
	private String postDisc;                                                                                        
	private String imageUrl;                                                                                        
	                                                                                                                
	@Transient                                                                                                      
	private File file;

	public Images(Integer imageId, String postDisc, String imageUrl, File file) {
		super();
		this.imageId = imageId;
		this.postDisc = postDisc;
		this.imageUrl = imageUrl;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Images [imageId=" + imageId + ", postDisc=" + postDisc + ", imageUrl=" + imageUrl + ", file=" + file
				+ "]";
	}                                                                                              
                                                                                                                    
	               
}