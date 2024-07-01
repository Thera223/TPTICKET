package com.example.test.service;

import com.example.test.model.StatutTicket;
import com.example.test.model.Ticket;
import com.example.test.model.Utilisateur;
import com.example.test.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
@Getter
@AllArgsConstructor
public class TicketServiceimpl implements TicketService {
    private final TicketRepository ticketRepository;

    @Override
    public String creerticket(Ticket ticket) {
        ticket.setStatut(StatutTicket.EN_COURS);
         ticketRepository.save(ticket);
        return "Votre Ticket a éte créée et est encours de traitement, vous serez notifiez pour la prise en charge";
    }

    @Override
    public String supprimerticket(Long id) {
        ticketRepository.deleteById((long) id);
        return "Ticket supprimer";
    }

    @Override
    public List<Ticket> lireticket() {
        return ticketRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    /**
     * @param ticket
     * @return
     */
    @Override
    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * @param utilisateur
     * @return
     */
    @Override
    public List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) {
        return ticketRepository.findByUtilisateur(utilisateur);
    }
//
//    /**
//     * @param utilisateur
//     * @return
//     */
//    @Override
//    public List<Ticket> lireTicketsParUtilisateurlTickets(Utilisateur utilisateur) {
//        return ticketRepository.findByUtilisateur(utilisateur);
//    }


}