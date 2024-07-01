package com.example.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "REPONSETICKET")
@Getter
@Setter
@NoArgsConstructor
public class ReponseTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "formateur_id")
    private Utilisateur formateur;

    private String contenu;
    LocalDate date = LocalDate.now();
}
