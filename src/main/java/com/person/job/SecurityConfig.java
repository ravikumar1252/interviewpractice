package com.person.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	http.authorizeRequests()
		.antMatchers("/")
		.permitAll().antMatchers("/welcome")
		.hasAnyRole("USER", "ADMIN")
		.antMatchers("/plist")
		.hasAnyRole("USER", "ADMIN")
		.antMatchers("/indexpage")
		.hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().logout().permitAll();

		http.csrf().disable();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user")
		.password("{noop}password")
		.authorities("ROLE_USER")
		.and()
		.withUser("admin")
		.password("{noop}password")
		.authorities("ROLE_USER", "ROLE_ADMIN");

	}
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("user").password("{noop}password").roles("USER") .and()
	 * .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	 * 
	 * }
	 * 
	 * // Secure the endpoins with HTTP Basic authentication
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * http //HTTP Basic authentication .httpBasic() .and() .authorizeRequests()
	 * .antMatchers(HttpMethod.GET, "/plist/**").hasRole("USER")
	 * .antMatchers(HttpMethod.POST, "/plist").hasRole("ADMIN")
	 * .antMatchers(HttpMethod.PUT, "/plist/**").hasRole("ADMIN")
	 * .antMatchers(HttpMethod.PATCH, "/plist/**").hasRole("ADMIN")
	 * .antMatchers(HttpMethod.DELETE, "/plist/**").hasRole("ADMIN") .and()
	 * .csrf().disable() .formLogin().disable(); }
	 */

}
