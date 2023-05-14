package com.blackwolfhk.security.auth;

import com.blackwolfhk.security.config.JwtService;
import com.blackwolfhk.security.user.Role;
import com.blackwolfhk.security.user.User;
import com.blackwolfhk.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    // instance variables for the class
    // They are marked as final because they are set in the constructor and should not be changed afterwards
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        // A new User object is created using the builder pattern and the request parameters
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        // The user is saved to the repository
        repository.save(user);

        // A new JWT token is generated for the user
        var jwtToken = jwtService.generateToken(user);

        // An AuthenticationResponse object is returned with the token
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // The user is retrieved from the repository using the email address
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);

        // An AuthenticationResponse object is returned with the token
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
