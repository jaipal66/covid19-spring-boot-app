package com.jp.spring.security.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jp.spring.security.jwt.JWTUtils;
import com.jp.spring.security.models.AuthenticationRequest;
import com.jp.spring.security.models.AuthenticationResponse;
import com.jp.spring.security.services.MyUserDetailService;

@RestController
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private JWTUtils jwtUtils;

	@RequestMapping(value = "/user")
	public String getUsers() {
		return "User Page";
	}
	
	@RequestMapping(value = "/admin")
	public String getAdmin() {
		return "Admin Page";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		LOGGER.info("{} and {} to create token ",authenticationRequest.getUserName(),authenticationRequest.getPassword());
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			LOGGER.error("Incorrect UserName or Password");
			throw new Exception("Incorrect UserName or Password " + e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtUtils.generateToken(userDetails);
		LOGGER.info("jwt token {} ",jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}