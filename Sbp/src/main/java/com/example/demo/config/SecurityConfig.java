package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//ignore the url
	    web
		  .ignoring()
		  .antMatchers("/webjars/**")
		   .antMatchers("/js/**")
		  .antMatchers("/h2-conconsole/**")
		  .antMatchers("/css/**");
		  
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	    http.authorizeRequests()
		    .antMatchers("/login").permitAll()
		    .antMatchers("/user/signup").permitAll()
		    .antMatchers("/admin").hasAuthority("ADMIN")
		    .anyRequest().authenticated();
		
			
		 http.formLogin().loginProcessingUrl("/login") .loginPage("/login")
		      
			  .usernameParameter("userId") .passwordParameter("password")
			  .failureUrl("/login?error") .defaultSuccessUrl("/user/list", true);
		 
		 
			 
		 http.logout()
		    .logoutUrl("/logout")
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .logoutSuccessUrl("/login?logout");
		 
		 
		http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		  PasswordEncoder encoder = passwordEncoder();
		
			/*
			 * auth.inMemoryAuthentication() .withUser("user")
			 * .password(encoder.encode("user")) .roles("GENERAL");
			 */
		 
		
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}
	
	
	
	
}
