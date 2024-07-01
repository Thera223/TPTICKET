package com.example.test.repository;

import com.example.test.model.RoleType;
import com.example.test.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByUsername(String username);
    List<Utilisateur> findByRole(RoleType role);
}