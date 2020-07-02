package com.jp.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.course.entity.Course;
import com.jp.course.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(int topicId) {
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicTopicId(topicId).forEach(courses::add);
		return courses;

	}

	public Course findById(int courseId) {
		Optional<Course> topic = courseRepository.findById(courseId);
		return topic.get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
}
