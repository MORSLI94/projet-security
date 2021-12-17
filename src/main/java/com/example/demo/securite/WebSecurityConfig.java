package com.example.demo.securite;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*
	 * @Bean 
public PasswordEncoder passwordEncoder() { 
    return new BCryptPasswordEncoder(); 
}
	 */
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	                .withUser("morsli")
	                .password("{noop}123456")
	                .roles("ADMIN")
	                .and()
	                .withUser("admin")
	                .password("{noop}123456789")
	                .roles("MANAGER");
	    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//.csrf().disable()
		http
		.authorizeRequests()
			.antMatchers("/dash/**").permitAll()
			.antMatchers("/css/**","/js/**").permitAll()
			.antMatchers("/signin").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/dash")
			.permitAll()
			.and()
		.logout()
			.permitAll()
			;
	}
	
}
