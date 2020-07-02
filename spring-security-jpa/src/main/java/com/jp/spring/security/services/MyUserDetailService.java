package com.jp.spring.security.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jp.spring.security.entity.User;
import com.jp.spring.security.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailService.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LOGGER.info("before calling userrepository username is {}",userName);
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException("Not Found : " + userName));
		LOGGER.info("{}",user.get());
		return user.map(MyUserDetails::new).get();

	}

}
