package com.jp.covid19.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jp.covid19.dto.UserRegistrationDto;
import com.jp.covid19.entity.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
