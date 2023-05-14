package com.blackwolfhk.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    // This field is final and is initialized through the constructor
    private final AuthenticationService service;

    // This method is a POST endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            // This annotation specifies that the request body should be deserialized into a RegisterRequest object
            @RequestBody RegisterRequest request
    ) {
        // This method returns a ResponseEntity containing the result of the registration process
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(
            // This annotation specifies that the request body should be deserialized into an AuthenticationRequest object
            @RequestBody AuthenticationRequest request
    ) {
        // This method returns a ResponseEntity containing the result of the authentication process
        return ResponseEntity.ok(service.authenticate(request));
    }
}
