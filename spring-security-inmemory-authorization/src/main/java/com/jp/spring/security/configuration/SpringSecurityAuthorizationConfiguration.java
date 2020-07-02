package com.jp.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityAuthorizationConfiguration extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("jaipal")
		.password("Mar$4321")
		.roles("USER_ROLE")
		.and()
		.withUser("kumar")
		.password("March$4321")
		.roles("ADMIN_ROLE");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/admins").hasRole("ADMIN_ROLE")
		.antMatchers("/users").hasRole("USER_ROLE")
		.antMatchers("/*").permitAll()
		.and()
		.formLogin();
	}
	
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
