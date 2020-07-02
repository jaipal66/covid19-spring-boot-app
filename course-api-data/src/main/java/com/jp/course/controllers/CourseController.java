package com.jp.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.course.entity.Course;
import com.jp.course.entity.Topic;
import com.jp.course.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

    @RequestMapping(value= "/{text:[a-z-]+}.{number:[\\d]+}")
	public String  method(@PathVariable String text,@PathVariable String number) {
		return "";
	}
	
	
	@RequestMapping(value = "/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable int topicId) {
		return courseService.getCourses(topicId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}")
	public Course getCourseById(@PathVariable int courseId) {
		return courseService.findById(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/Course/{courseId}")
	public void deleteCourse(@PathVariable int courseId) {
		courseService.deleteCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course,@PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
}
