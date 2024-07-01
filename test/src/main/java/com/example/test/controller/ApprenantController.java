package com.example.test.controller;

import com.example.test.model.*;
import com.example.test.repository.TicketRepository;
import com.example.test.repository.UtilisateurRepository;
import com.example.test.service.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/apprenant")
public class ApprenantController {

    private final BaseConnaissanceService baseConnaissanceService;
    private final ReponseTicketService reponseTicketService;
    private final TicketService ticketService;
    private final UtilisateurService utilisateurService;
    private final TicketRepository ticketRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final NotificationService notificationService;
    @PostMapping("/creerticket")
    @Operation(summary = "CLIQUER ICI POUR  CREER UN TICKET", description = "Cette methode permet de creer un ticket")

    public String createticket(@RequestBody Ticket ticket) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Recherche de l'utilisateur par nom d'utilisateur
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));

        // Assigner l'utilisateur connecté au ticket
        ticket.setUtilisateur(utilisateur);
        String nouveauTicket = ticketService.creerticket(ticket);
        notificationService.envoyerNotification(utilisateur, "Nouveu ticket ajouté et est en cours de traiment.");
        return nouveauTicket;

    }

    @DeleteMapping("/deleteticket/{id}")
    @Operation(summary = "CLIQUER ICI POUR SUPPRIMER UN TICKET", description = "Cette methode permet de supprimer un ticket a travers son id")

    public String deleteticket(@PathVariable Long id) {
        return ticketService.supprimerticket(id);
    }

    @GetMapping("/readlistticket")
    @Operation(summary = "CLIQUER ICI POUR VOIR LA LISTE DES TICKETS", description = "Cette methode permet de voir la liste de ticket")

    public List<Ticket> readlistticket() {
        return ticketService.lireticket();
    }

    @GetMapping("/lirenotification")
    @Operation(summary = "CLIQUER POUR VOIR LES NOTIFICATIONS", description = "Cette liste contient l'historique de notification")
    public List<Notification> lirenotification() {return notificationService.lireNotifications();}



    @GetMapping("/readreponseticket")
    @Operation(summary = "CLIQUER ICI POUR VOIR LES REPONSES DES TICKETS ENVOYER PAR LE FORMATEUR", description = "Cette methode permet de voir les reponses des tickets")

    public List<ReponseTicket> readreponseticket() {
        return reponseTicketService.lire();
    }

    @GetMapping("/readbaseconnaissance")
    @Operation(summary = "CLIQUER ICI POUR VOIR LA BASE DE CONNAISSANCE", description = "Cette methode permet de voir la base de connaissance sans pour autant soumettre  un ticket")

    public List<BaseConnaissance> readbaseconnaissance() {
        return baseConnaissanceService.lireBaseConnaissance();
    }
}

