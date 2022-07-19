package com.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.okta.spring.boot.oauth.Okta;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// protect endpoints /api/orders
		http.authorizeRequests().antMatchers("/api/orders/**").authenticated().and().oauth2ResourceServer().jwt();

		// add cors filters
		http.cors();

		// force a non empty body for 401 to make the response
		Okta.configureResourceServer401ResponseBody(http);

		// disable csrf tokenswe are not using cookies for session traking
		http.csrf().disable();
	}

}
