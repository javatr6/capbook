package org.flp.capbook.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="friends_list")
public class FriendsList {
	
	
    @Id
    private Integer id;
    
	private String friendName;

	
	public FriendsList(Integer id, String friendName) {
		super();
		this.id = id;
		this.friendName = friendName;
	}

	public FriendsList() {
		super();
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FriendsList [id=" + id + ", friendName=" + friendName + "]";
	}

	
	
}
