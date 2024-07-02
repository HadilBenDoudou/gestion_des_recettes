package com.hadilhadil.hadil.Service;

import com.hadilhadil.hadil.model.Recette;

import java.util.List;
import java.util.Optional;

public interface RecetteService {
    Recette save(Recette recette);
    Optional<Recette> findById(Long id);
    List<Recette> obtenirRecettesParChef(long idChef);
    List<Recette> findAll();
    void deleteById(Long id);

    void updateFavoris(Long id, boolean favoris);

    List<Recette> findByFavoris(boolean b);



}
