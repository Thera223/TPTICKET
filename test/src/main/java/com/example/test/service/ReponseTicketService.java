package com.example.test.service;

import com.example.test.model.ReponseTicket;
import com.example.test.model.Ticket;
import com.example.test.model.Utilisateur;

import java.util.List;

public interface ReponseTicketService {
    ReponseTicket creerreponseticket(ReponseTicket reponseticket);
    String supprimerreponseticket(Long id);
    List<ReponseTicket> lire();
    List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) ;

    }


