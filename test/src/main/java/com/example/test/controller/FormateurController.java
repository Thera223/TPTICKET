package com.example.test.controller;

import com.example.test.model.*;
import com.example.test.repository.TicketRepository;
import com.example.test.repository.UtilisateurRepository;
import com.example.test.service.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@Setter
@RestController
@AllArgsConstructor
@RequestMapping("/formateur")
public class FormateurController {


    private final TicketRepository ticketRepository;
    private final NotificationService notificationService;
    private final UtilisateurService utilisateurService;
    private final TicketService ticketService;
    private final BaseConnaissanceService baseConnaissanceService;
    private final ReponseTicketService reponseTicketService;
    private final UtilisateurRepository utilisateurRepository;


    @PostMapping("/creereponseticket")
    @Operation(summary = "CLIQUER ICI POUR CREER UNE REPONSETICKET", description = "Cette methode permet de creer une reponseticket")

    public ReponseTicket creerreponseticket(@RequestBody ReponseTicket reponseTicket, @RequestParam Long ticketId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trouvé avec l'ID : " + ticketId));

        reponseTicket.setFormateur(utilisateur);
        reponseTicket.setTicket(ticket);


        ticket.setStatut(StatutTicket.RESOLU);
        ticketService.updateTicket(ticket);
        notificationService.envoyerNotification(ticket.getUtilisateur(), "Votre ticket a été mis à jour au statut 'RESOLU'.");

        return reponseTicketService.creerreponseticket(reponseTicket);
    }


    @GetMapping("/readreponseticket")
    @Operation(summary = "CLIQUER ICI POUR VOIR LES REPONSES DES TICKETS ", description = "Cette methode permet de voir les reponses des tickets")

    public List<ReponseTicket> readreponseticket() {
        return reponseTicketService.lire();
    }

    @DeleteMapping("/deletereponseticket/{id}")
    @Operation(summary = "CLIQUER ICI POUR SUPPRIMER LES REPONSES DES TICKETS", description = "Cette methode permet de supprimer les reponses des tickets a travers leur id")

    public String deletereponseticket(@PathVariable Long id) {
        return reponseTicketService.supprimerreponseticket(id);
    }

    @GetMapping("/readbaseconnaissance")
    @Operation(summary = "CLIQUER ICI POUR VOIR LES BASES DE CONNAISSANCES CREER PAR LE FORMATEUR", description = "Cette methode permet de voir les bases de connaissances")

    public List<BaseConnaissance> readbaseconnaissance() {
        return baseConnaissanceService.lireBaseConnaissance();
    }

    @PostMapping("/createbaseconnaissance")
    @Operation(summary = "CLIQUER ICI POUR CREER LES DONNEES DANS LA BASE DE CONNAISSANCE", description = "Cette methode permet de creer les bases de connaissances")

    public BaseConnaissance createbaseconnaissance(@RequestBody BaseConnaissance baseConnaissance) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();


        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));


        baseConnaissance.setUtilisateur(utilisateur);

        return baseConnaissanceService.ajouterBaseConnaissance(baseConnaissance);

    }

    @DeleteMapping("/deletebaseConnaissance/{id}")
    @Operation(summary = "CLIQUER ICI POUR SUPPRIMER LA BASE DE CONNAISSANCE", description = "Cette methode permet de supprimer la base de connaissance a travers son id")

    public String deletebaseConnaissance(@PathVariable Long id) {
        return baseConnaissanceService.supprimerBaseConnaissance(id);
    }

    @GetMapping("/lirePourFormateur")
    @Operation(summary = "CLIQUER ICI POUR VOIR LES TICKETS DES APPRENANTS", description = "Cette methode permet de voir les tickets des apprenants")

    public List<Ticket> lireTicketsPourFormateur() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur non trouvé: " + username));

        if (!utilisateur.getRole().equals(RoleType.FORMATEUR)) {
            throw new IllegalArgumentException("Accès refusé : utilisateur non formateur");
        }

        List<Ticket> tickets = ticketService.lireticket();

        for (Ticket ticket : tickets) {
            if (ticket.getStatut() == StatutTicket.EN_COURS) {
                ticket.setStatut(StatutTicket.OUVERT);
                ticketService.updateTicket(ticket);
                notificationService.envoyerNotification(ticket.getUtilisateur(), "Votre ticket a été mis à jour au statut 'OUVERT'.");
            }
        }

        return tickets;
    }
    @GetMapping("/lirenotification")
    @Operation(summary = "CLIQUER POUR VOIR LES NOTIFICATIONS", description = "Cette liste contient l'historique de notification")
    public List<Notification> lirenotification() {return notificationService.lireNotifications();}




}
