package com.example.test.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="APPRENANT")
@Entity
@NoArgsConstructor
@Data
public class Apprenant extends Utilisateur {
    public Apprenant (String username, String motDePasse) {
        super(username, motDePasse, RoleType.APPRENANT);
    }


}

