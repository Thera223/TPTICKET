package com.example.test.controller;

import com.example.test.model.Apprenant;
import com.example.test.model.Formateur;
import com.example.test.model.Utilisateur;
import com.example.test.model.Admin;
import com.example.test.service.UtilisateurService;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UtilisateurService utilisateurService;

//    @PostMapping("/creeradmin")
//    public Utilisateur creerAdmin(@RequestBody Admin admin) {
//        return utilisateurService.ajouterAdmin(admin);
//    }

    @PostMapping("/creerformateur")
    @Operation(summary = "CLIQUER ICI POUR AJOUTER UN FORMATEUR", description = "Cette methode permet de creer un Formateur")
    public String creerFormateur(@RequestBody Formateur formateur) {
        return utilisateurService.ajouterFormateur(formateur);
    }

    @PostMapping("/creerapprenant")
    @Operation(summary = "CLIQUER ICI POUR AJOUTER UN APPRENANT", description = "Cette methode permet de creer un Apprenant")

    public String creerApprenant(@RequestBody Apprenant apprenant) {
        return utilisateurService.ajouterApprenant(apprenant);
    }

    @PutMapping("/modifieradmin/{id}")
    @Operation(summary = "CLIQUER ICI POUR MODFIER L'ADMIN PAR DEFAULT", description = "Cette methode permet de modifier les identifiant de l'admin par default")

    public String modifierAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return utilisateurService.modifierAdmin(id, admin);
    }

    @GetMapping("/listutilisateurs")
    @Operation(summary = "CLIQUER ICI POUR LA LISTE DES UTILISATEURS", description = "Cette methode permet de voir la liste des utilisateurs")

    public List<Utilisateur> lireUtilisateurs() {
        return utilisateurService.lireUtilisateurs();
    }

    @DeleteMapping("/supprimerutilisateur/{id}")
    @Operation(summary = "CLIQUER ICI POUR SUPPRIMER UN UTILISATEUR", description = "Cette methode permet de supprimer un utilisateur a travers son id")

    public String supprimerUtilisateur(@PathVariable Long id) {
        return utilisateurService.supprimerUtilisateur(id);
    }
}
