package com.example.test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "TICKET")
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    LocalDate date = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    private Categorie categorie;

    @Enumerated(EnumType.STRING)
    private StatutTicket statut;

    public Ticket(String description, Categorie categorie, Utilisateur utilisateur) {
        this.description = description;
        this.categorie = categorie;
        this.utilisateur = utilisateur;
        this.statut = StatutTicket.EN_COURS;
    }

    public void mettreAJourStatut(StatutTicket statut) {
        this.statut = statut;
    }
}
