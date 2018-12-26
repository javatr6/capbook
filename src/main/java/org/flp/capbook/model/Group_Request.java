package org.flp.capbook.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Group_Request {
@Id
@GeneratedValue
	private Integer g_requestId;
	private Integer groupId;
	private Integer userId;
	private String status="Pending";
	public Group_Request() {
		super();
	}
	public Group_Request(Integer g_requestId, Integer groupId, Integer userId, String status) {
		super();
		this.g_requestId = g_requestId;
		this.groupId = groupId;
		this.userId = userId;
		this.status = status;
	}
	public Integer getG_requestId() {
		return g_requestId;
	}
	public void setG_requestId(Integer g_requestId) {
		this.g_requestId = g_requestId;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Group_Request [g_requestId=" + g_requestId + ", groupId=" + groupId + ", userId=" + userId + ", status="
				+ status + "]";
	}
	
	
}
