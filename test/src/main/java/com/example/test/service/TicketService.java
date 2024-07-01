package com.example.test.service;

import com.example.test.model.Ticket;
import com.example.test.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    String creerticket(Ticket ticket);
    String supprimerticket(Long id);
    List<Ticket> lireticket();

    Optional<Ticket> findById(Long id);
    Ticket updateTicket(Ticket ticket);
    List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) ;
}
