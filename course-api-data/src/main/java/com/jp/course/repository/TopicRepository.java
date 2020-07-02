package com.jp.course.repository;

import org.springframework.data.repository.CrudRepository;

import com.jp.course.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, Integer>{

}
