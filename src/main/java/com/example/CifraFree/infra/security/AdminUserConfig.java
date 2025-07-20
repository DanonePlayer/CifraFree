package com.example.CifraFree.infra.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.CifraFree.domain.usuario.entities.Usuario;
import com.example.CifraFree.infra.usuario.repositories.UsuarioRepository;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private UsuarioRepository usuarioRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminUserConfig(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var userAdmin = usuarioRepository.findByEmail("admin@example.com");

        userAdmin.ifPresentOrElse(
            user -> {
                System.out.println("Admin user already exists");
            }, () -> {
                var user = new Usuario();
                user.setName("Admin");
                user.setEmail("admin@example.com");
                user.setPassword(bCryptPasswordEncoder.encode("123"));
                user.setRole(com.example.CifraFree.infra.Enums.Role.ADMIN);
                usuarioRepository.save(user);
            }
        );
    }
    
}
