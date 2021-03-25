package com.ga.blogapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity // hint to the compiler as a marker annotation, to add it to the spring framework (config this class also to your framework) because I'm overriding some methods
public class SecurityConfig extends WebSecurityConfigurerAdapter{ // apply security to all the routes
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Bean //to resister that library to used it in this application .. use bean annotation
	// to tell what type of encryption we used
	public PasswordEncoder passwordEncoder() {
		//when you're doing the authentication.. use the same encrypted password
		return new BCryptPasswordEncoder();
	}
	
	
	//Override Authentication Methods
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	
	//Override Authorization (privilege) Methods
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		//csrf is an attack
		//.csrf().disable()// whenever there is token not compatible disable it (when user write script in inputs .. we protect out app) `this is not GP .. the good is to do it using html`
		// Included this line in all pages that have post method `<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />` to protect from csrf attack
		.authorizeRequests()
		.antMatchers("/author/add", "/article/add").hasAnyRole("ADMIN", "USER")// it should be capital to define the role (common thing in programming)
		.antMatchers("/author/edit", "/article/edit").hasAnyRole("ADMIN", "USER")
		.antMatchers("/author/delete", "/article/delete").hasAnyRole("ADMIN")
		
		.and().formLogin()
		
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//so that it doesn't ask me for "are you sure you want to logout"
		.logoutSuccessUrl("/").deleteCookies("JSESSIONID").invalidateHttpSession(true)//after success logout, delete the cookies and redirect to home page
		;
	}

}
