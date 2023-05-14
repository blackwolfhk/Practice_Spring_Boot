package com.blackwolfhk.security.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable() // Disables CSRF protection
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**") // Allows all requests to endpoints that match "/api/v1/auth/**"
                .permitAll()
                .anyRequest()
                .authenticated() // Requires authentication for all other requests
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Sets session creation policy to stateless
                .and()
                .authenticationProvider(authenticationProvider) // Registers the AuthenticationProvider bean
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Adds JwtAuthenticationFilter before UsernamePasswordAuthenticationFilter

        // Returns the configured SecurityFilterChain
        return http.build();
    }
}
