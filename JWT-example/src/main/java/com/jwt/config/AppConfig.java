package com.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails userDetails = User.builder().username("ajay").password(passwordEncoder().encode("ajay")).roles("ADMIN").build();
        UserDetails user2Details = User.builder().username("appi").password(passwordEncoder().encode("appi")).roles("ADMIN").build();
        UserDetails user3Details = User.builder().username("kuthe").password(passwordEncoder().encode("kuthe")).roles("ADMIN").build();

        return new InMemoryUserDetailsManager(userDetails,user2Details,user3Details);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
