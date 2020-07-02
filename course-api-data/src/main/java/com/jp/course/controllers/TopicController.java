package com.jp.course.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.course.entity.Topic;
import com.jp.course.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(method = RequestMethod.GET, value = "/topics")
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}")
	public Topic getTopicById(@PathVariable int topicId) {
		return topicService.findById(topicId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}")
	public void deleteTopic(@PathVariable int topicId) {
		topicService.deleteTopic(topicId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}")
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
}
