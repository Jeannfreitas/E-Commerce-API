package com.commerce.API.E_commerce.controller;

import com.commerce.API.E_commerce.model.Usuario;
import com.commerce.API.E_commerce.repository.UsuarioRepository;
import com.commerce.API.E_commerce.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuario);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getSenha())
        );
        return jwtUtil.generateToken(usuario.getUsername());
    }
}
