package com.jp.course.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	private int courseId;
	private String name;
	private String description;
	
	@ManyToOne
	private Topic topic;
	
	
	public Course() {}
	public Course(int courseId, String name, String description) {
		this.courseId = courseId;
		this.name = name;
		this.description = description;
		this.topic = new Topic(1,"","");
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
