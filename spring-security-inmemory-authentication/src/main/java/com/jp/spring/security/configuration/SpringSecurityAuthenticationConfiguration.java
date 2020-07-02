package com.jp.spring.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityAuthenticationConfiguration  extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("jaipal")
		.password("Mar$4321")
		.roles("USER")
		.and()
		.withUser("kumar")
		.password("March$4321")
		.roles("ADMIN");
	}
	@Bean
	public PasswordEncoder createPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
