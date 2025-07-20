package com.example.CifraFree.infra.security.controllers;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.RestController;

import com.example.CifraFree.application.login.dto.LoginRequest;
import com.example.CifraFree.application.login.dto.LoginResponse;
import com.example.CifraFree.infra.usuario.repositories.UsuarioRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/auth")
public class TokenController {
    
    private final JwtEncoder jwtEncoder;
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder jwtEncoder, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        var user = usuarioRepository.findByEmail(loginRequest.email());
        if (user.isEmpty()) {
            throw new BadCredentialsException("Usuário ou senha não encontrado");
        }
        if (!bCryptPasswordEncoder.matches(loginRequest.password(), user.get().getPassword())) {
            throw new BadCredentialsException("Usuário ou senha não encontrado");
        }

        var now = Instant.now();
        var expiration = 300L;

        var claims = JwtClaimsSet.builder()
                .issuer("CifraFree")
                .subject(user.get().getId().toString())
                .expiresAt(now.plusSeconds(expiration))
                .issuedAt(now)
                .claim("userId", user.get().getId())
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue, expiration));
    }
    
}
