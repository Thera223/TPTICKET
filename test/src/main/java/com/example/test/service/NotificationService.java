package com.example.test.service;

import com.example.test.model.Notification;
import com.example.test.model.Utilisateur;
import com.example.test.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public List<Notification> lireNotifications() {
        return notificationRepository.findAll();
    }

    public Notification envoyerNotification(Utilisateur utilisateur, String message) {
        Notification notification = new Notification(utilisateur, message);
        return notificationRepository.save(notification);
    }

}
