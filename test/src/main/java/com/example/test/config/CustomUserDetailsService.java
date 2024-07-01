package com.example.test.config;

import com.example.test.model.Utilisateur;
import com.example.test.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByUsername(username);

        if (!utilisateurOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        Utilisateur utilisateur = utilisateurOptional.get();

        return User.builder()
                .username(utilisateur.getUsername())
                .password(utilisateur.getMotDePasse())
                .roles(utilisateur.getRole().name())
                .build();
    }
}
