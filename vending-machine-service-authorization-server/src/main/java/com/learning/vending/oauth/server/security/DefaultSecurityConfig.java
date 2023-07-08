package com.learning.vending.oauth.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.learning.vending.oauth.server.service.impl.CustomAuthenticationProvider;

@EnableWebSecurity
public class DefaultSecurityConfig {

	@Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    	http
        // disabling csrf since we won't use form login
        .csrf().disable()
        // giving permission to every request for /login endpoint
        // .authorizeHttpRequests((authz) -> authz.requestMatchers("/vendingmachine/signin").permitAll().anyRequest().authenticated())
        .authorizeHttpRequests((authz) -> authz.anyRequest().authenticated())
        // for everything else, the user has to be authenticated
      //  .formLogin().loginPage("/vendingmachine/signin").permitAll().and()
        .formLogin(Customizer.withDefaults())
//        .logout(logout -> logout
//                .logoutRequestMatcher(new AntPathRequestMatcher("/vendingmachine/signout"))
//                .permitAll())
        // setting stateless session, because we choose to implement Rest API
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }

    @Autowired
    public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder
                .authenticationProvider(customAuthenticationProvider);
    }
}
