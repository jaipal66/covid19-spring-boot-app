package com.jp.spring.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jp.spring.security.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUserName(String userName);
}
