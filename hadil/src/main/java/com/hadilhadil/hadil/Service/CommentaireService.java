package com.hadilhadil.hadil.Service;

import com.hadilhadil.hadil.Repository.CommentaireRepository;
import com.hadilhadil.hadil.model.Commentaire;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private final CommentaireRepository commentaireRepository;

    @Autowired
    public CommentaireService(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    public void save(Commentaire commentaire) {
        commentaireRepository.save(commentaire);
    }


    public List<Commentaire> getCommentairesByRecetteId(Long recetteId) {
        return commentaireRepository.findByRecetteIdRecette(recetteId);
    }

    public void supprimerCommentaire(Long idCommentaire) {
        commentaireRepository.deleteById(idCommentaire);
    }
    public ResponseEntity<Commentaire> updateCommentaire(Long id, String contenu) {
        Optional<Commentaire> optionalCommentaire = commentaireRepository.findById(id);

        if (optionalCommentaire.isPresent()) {
            Commentaire commentaire = optionalCommentaire.get();
            commentaire.setContenu(contenu); // Mettre à jour le contenu du commentaire

            // Enregistrer les modifications dans la base de données
            commentaireRepository.save(commentaire);

            // Retourner une réponse avec le commentaire mis à jour
            return ResponseEntity.ok(commentaire);
        } else {
            // Retourner une réponse avec un statut 404 Not Found si le commentaire n'est pas trouvé
            return ResponseEntity.notFound().build();
        }
    }
}
