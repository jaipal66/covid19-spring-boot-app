 package com.jp.metro.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.metro.card.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
