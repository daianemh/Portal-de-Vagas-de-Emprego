
package com.seuusuario.portalvagas.controller;

import com.seuusuario.portalvagas.dto.JwtResponse;
import com.seuusuario.portalvagas.dto.LoginRequest;
import com.seuusuario.portalvagas.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());

        authenticationManager.authenticate(authenticationToken);

        String token = tokenProvider.generateToken(authenticationToken);

        return new JwtResponse(token);
    }
}
