package com.flxn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Gadzzzz on 15.03.2016.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//	private final UserService userService;
	private final TokenAuthenticationService tokenAuthenticationService;

	private final String SECRET = "tooManySecrets";

	public SpringSecurityConfig() {
		super(true);
//		this.userService = new UserService();
		this.tokenAuthenticationService = new TokenAuthenticationService(/*, userService*/);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.exceptionHandling()
		.and()
			.anonymous()
		.and()
			.servletApi()
		.and()
			.headers()
			.cacheControl()
		.and()
			.authorizeRequests()
			.antMatchers("/resource/auth/**").permitAll()
			.anyRequest().authenticated()
		.and()
			.addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService),
			UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(new PlaintextPasswordEncoder());//.passwordEncoder(new BCryptPasswordEncoder())
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	@Scope("prototype")
	@Override
	public UserService userDetailsService() {
		return new UserService();
	}

	@Bean
	@Scope("prototype")
	public TokenHandler tokenHandler(){
		return new TokenHandler(SECRET,userDetailsService());
	}

	@Bean
	public TokenAuthenticationService tokenAuthenticationService() {
		return tokenAuthenticationService;
	}
}