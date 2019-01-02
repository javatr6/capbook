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
	private Integer topic_id;
	private Integer topic_started_by;
	
	private String topic_desc;
	private Integer group_id;
	/*@OneToMany(mappedBy="topicId",targetEntity=Group_Comments.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Group_Comments> group_comments = new ArrayList<>();*/
	
	public Group_Topic() {
		super();
	}

	public Integer getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(Integer topic_id) {
		this.topic_id = topic_id;
	}

	public Integer getTopic_started_by() {
		return topic_started_by;
	}

	public void setTopic_started_by(Integer topic_started_by) {
		this.topic_started_by = topic_started_by;
	}

	public String getTopic_desc() {
		return topic_desc;
	}

	public void setTopic_desc(String topic_desc) {
		this.topic_desc = topic_desc;
	}

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Group_Topic(Integer topic_id, Integer topic_started_by, String topic_desc, Integer group_id) {
		super();
		this.topic_id = topic_id;
		this.topic_started_by = topic_started_by;
		this.topic_desc = topic_desc;
		this.group_id = group_id;
	}

	@Override
	public String toString() {
		return "Group_Topic [topic_id=" + topic_id + ", topic_started_by=" + topic_started_by + ", topic_desc="
				+ topic_desc + ", group_id=" + group_id + "]";
	}

	
}
