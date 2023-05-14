package com.blackwolfhk.security.config;

import com.blackwolfhk.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository repository;

    /* The @Bean annotation is typically used in a configuration class,
    which is a class annotated with @Configuration that defines the beans
    to be created and their dependencies.*/

    /* Defines a bean for the UserDetailsService interface.
    Returns a lambda that takes a username as input, queries the database for
    the corresponding user, and returns the UserDetails object for that user.
    If the user is not found, a UsernameNotFoundException is thrown. */
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /* Defines a bean for the AuthenticationProvider interface.
    Creates a DaoAuthenticationProvider instance and sets its userDetailsService
    property to the userDetailsService bean defined above.
    Also sets the passwordEncoder property to the passwordEncoder bean. */
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /* Defines a bean for the AuthenticationManager interface.
    Takes an AuthenticationConfiguration object as input, which is automatically
    injected by Spring Security.
    Returns the authentication manager from the configuration object. */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /* Defines a bean for the PasswordEncoder interface.
    Returns a BCryptPasswordEncoder instance. */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
