package com.example.test.service;

import com.example.test.model.ReponseTicket;
import com.example.test.model.Ticket;
import com.example.test.model.Utilisateur;
import com.example.test.repository.ReponseTicketRepository;
import com.example.test.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@Service
public class ReponseTicketServiceimpl implements ReponseTicketService{

    private final TicketRepository ticketRepository;
    private final ReponseTicketRepository reponseTicketRepository;
//    @Override
//    public ReponseTicket creerreponseticket(ReponseTicket reponseticket) {
//        return reponseTicketRepository.save(reponseticket);
//    }

    /**
     * @param reponseticket
     * @return
     */
    @Override
    public ReponseTicket creerreponseticket(ReponseTicket reponseticket) {
        return reponseTicketRepository.save(reponseticket);
    }

    @Override
    public String supprimerreponseticket(Long id) {
        reponseTicketRepository.deleteById((long) id);
        return "REPONSETICKET SUPPRIMEE";
    }

    @Override
    public List<ReponseTicket> lire() {
        return reponseTicketRepository.findAll();
    }

    /**
     * @param utilisateur
     * @return
     */
    @Override
    public List<Ticket> lireTicketsParUtilisateur(Utilisateur utilisateur) {
        return ticketRepository.findByUtilisateur(utilisateur);
    }
}
