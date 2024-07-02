package com.hadilhadil.hadil.Repository;

import com.hadilhadil.hadil.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByRecetteIdRecette(Long idRecette);
    boolean existsById(Long id);
}

