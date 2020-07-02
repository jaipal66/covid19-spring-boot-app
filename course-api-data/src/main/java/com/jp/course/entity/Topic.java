package com.jp.course.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	private int topicId;
	private String name;
	private String description;

	public Topic() {
	}

	public Topic(int topicId, String name, String description) {
		this.topicId = topicId;
		this.name = name;
		this.description = description;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
