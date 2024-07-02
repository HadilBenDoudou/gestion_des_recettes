package com.hadilhadil.hadil.Controller;

import com.hadilhadil.hadil.Repository.CommentaireRepository;
import com.hadilhadil.hadil.Service.CommentaireService;
import com.hadilhadil.hadil.Service.RecetteService;
import com.hadilhadil.hadil.Service.UtilisateurService;
import com.hadilhadil.hadil.model.Commentaire;
import com.hadilhadil.hadil.model.Recette;
import com.hadilhadil.hadil.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recettes")
public class CommentaireController {

    private final CommentaireService commentaireService;
    CommentaireRepository commentaireRepository;
    private final RecetteService recetteService;
    private final UtilisateurService utilisateurService;


    @Autowired
    public CommentaireController(CommentaireService commentaireService, CommentaireRepository commentaireRepository, RecetteService recetteService, UtilisateurService utilisateurService) {
        this.commentaireService = commentaireService;
        this.commentaireRepository = commentaireRepository; // Injection du commentaireRepository
        this.recetteService = recetteService;
        this.utilisateurService = utilisateurService;
    }

    @PostMapping("/{recetteId}/comment")
    public ResponseEntity<Commentaire> ajouterCommentaire(
            @PathVariable Long recetteId,
            @RequestParam("contenu") String contenu,
            @RequestParam("utilisateurId") Long utilisateurId) {
        Optional<Recette> recetteOptional = recetteService.findById(recetteId);
        if (!recetteOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Utilisateur> utilisateurOptional = utilisateurService.findById(utilisateurId);
        if (!utilisateurOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(contenu);
        commentaire.setRecette(recetteOptional.get());
        commentaire.setUtilisateur(utilisateurOptional.get());

        commentaireService.save(commentaire);

        return new ResponseEntity<>(commentaire, HttpStatus.CREATED);
    }
    @GetMapping("/{recetteId}/commentaires")
    public List<Commentaire> getCommentaires(@PathVariable Long recetteId) {
        return commentaireService.getCommentairesByRecetteId(recetteId);
    }

    @DeleteMapping("/commentaires/{idCommentaire}")
    public ResponseEntity<String> supprimerCommentaire(@PathVariable Long idCommentaire) {
        try {
            commentaireService.supprimerCommentaire(idCommentaire);
            return new ResponseEntity<>("Le commentaire a été supprimé avec succès.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression du commentaire.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody String contenu) {
        return commentaireService.updateCommentaire(id, contenu);
    }

}
