package com.jp.course.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jp.course.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	

	public List<Course> findByTopicTopicId(int topicId);
}
