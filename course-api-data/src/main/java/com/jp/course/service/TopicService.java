package com.jp.course.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.course.entity.Topic;
import com.jp.course.repository.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;

	}

	public Topic findById(int topicId) {
		Optional<Topic> topic = topicRepository.findById(topicId);
		return topic.get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(int topicId) {
		topicRepository.deleteById(topicId);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}
}
