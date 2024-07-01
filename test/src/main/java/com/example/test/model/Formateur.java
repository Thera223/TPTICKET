package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="FORMATEUR")
@Entity
@NoArgsConstructor
@Data
public class Formateur extends Utilisateur {
    public Formateur(String username, String motDePasse) {
        super(username, motDePasse, RoleType.FORMATEUR);
    }
}
