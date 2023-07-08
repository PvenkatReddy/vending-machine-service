package com.learning.vending.resource.server.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration {
//
//	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
//	String jwkSetUri;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		http.csrf().disable()
				.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers(HttpMethod.GET, "/vendingmachine/**").hasAuthority("SCOPE_vendingmachine:read")
						.requestMatchers(HttpMethod.POST, "/vendingmachine/**").hasAuthority("SCOPE_vendingmachine:write")
						.anyRequest().authenticated()
				)
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
		// @formatter:on
		return http.build();
	}

//	@Bean
//	JwtDecoder jwtDecoder() {
//		return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
//	}

	
}