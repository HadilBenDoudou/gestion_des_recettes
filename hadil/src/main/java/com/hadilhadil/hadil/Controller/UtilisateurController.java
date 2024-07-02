package com.hadilhadil.hadil.Controller;

import com.hadilhadil.hadil.Service.UtilisateurService;
import com.hadilhadil.hadil.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public Utilisateur registerUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.saveUtilisateur(utilisateur);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur validUser = utilisateurService.validateUser(utilisateur.getLogin(), utilisateur.getPwd());
        if (validUser != null) {
            return ResponseEntity.ok(validUser.getIdUtilisateur());
        } else {
            return ResponseEntity.status(401).body("Invalid login or password");
        }
    }
}
