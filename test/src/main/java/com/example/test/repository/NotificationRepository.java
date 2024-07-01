package com.example.test.repository;

import com.example.test.model.Notification;
import com.example.test.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUtilisateur(Utilisateur utilisateur);
}
