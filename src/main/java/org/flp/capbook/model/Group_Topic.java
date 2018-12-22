package org.flp.capbook.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Group_Topic {
@Id
@GeneratedValue
	private Integer topicId;
	private Integer topic_startedBy;
	private String topic_desc;
	private Integer groupId;
	@OneToMany(mappedBy="topicId",targetEntity=Group_Comments.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Group_Comments> group_comments = new ArrayList<>();
	public Group_Topic() {
		super();
	}
	public Group_Topic(Integer topicId, Integer topic_startedBy, String topic_desc, Integer groupId,
			List<Group_Comments> group_comments) {
		super();
		this.topicId = topicId;
		this.topic_startedBy = topic_startedBy;
		this.topic_desc = topic_desc;
		this.groupId = groupId;
		this.group_comments = group_comments;
	}
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	public Integer getTopic_startedBy() {
		return topic_startedBy;
	}
	public void setTopic_startedBy(Integer topic_startedBy) {
		this.topic_startedBy = topic_startedBy;
	}
	public String getTopic_desc() {
		return topic_desc;
	}
	public void setTopic_desc(String topic_desc) {
		this.topic_desc = topic_desc;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public List<Group_Comments> getGroup_comments() {
		return group_comments;
	}
	public void setGroup_comments(List<Group_Comments> group_comments) {
		this.group_comments = group_comments;
	}
	@Override
	public String toString() {
		return "Group_Topic [topicId=" + topicId + ", topic_startedBy=" + topic_startedBy + ", topic_desc=" + topic_desc
				+ ", groupId=" + groupId + ", group_comments=" + group_comments + "]";
	}
	
	
}
