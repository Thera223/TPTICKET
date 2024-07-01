package com.example.test.service;

import com.example.test.model.Admin;
import com.example.test.model.Apprenant;
import com.example.test.model.Formateur;
import com.example.test.model.Utilisateur;

import java.util.List;


public interface UtilisateurService {


//    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
//
//     List<Utilisateur> lireUtilisateurs();
//
//    String supprimerUtilisateur(Long id);




    //Admin ajouterAdmin(Admin admin);
    String ajouterFormateur(Formateur formateur);
    String ajouterApprenant(Apprenant apprenant);
    //static Admin modifierAdmin(Long id, Admin admin);

    //Admin modifieradmin(Long id, Admin admin);

    String modifierAdmin(Long id, Admin adminDetails);

    List<Utilisateur> lireUtilisateurs();

    String supprimerUtilisateur(Long id);


}