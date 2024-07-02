package com.hadilhadil.hadil.Service;

import com.hadilhadil.hadil.Repository.ChefRepository;
import com.hadilhadil.hadil.Repository.RecetteRepository;
import com.hadilhadil.hadil.model.Chef;
import com.hadilhadil.hadil.model.Recette;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecetteServiceImpl implements RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    @Override
    public Recette save(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Override
    public Optional<Recette> findById(Long id) {
        return recetteRepository.findById(id);
    }

    @Override
    public List<Recette> obtenirRecettesParChef(long idChef) {
        return recetteRepository.findByChef_IdChef(idChef);
    }

    @Override
    public List<Recette> findAll() {
        return recetteRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        recetteRepository.deleteById(id);
    }
    @Autowired
    private ChefRepository chefRepository;

    public Chef ajouterChef(Chef chef) {
        // Vérifier si le login existe déjà dans la base de données
        Chef existingChef = chefRepository.findByLogin(chef.getLogin());
        if (existingChef != null) {
            throw new ChefExistException("Ce login est déjà utilisé par un autre chef.");
        }

        // Si le login n'existe pas, ajouter le nouveau chef
        return chefRepository.save(chef);
    }
    @Override
    public void updateFavoris(Long id, boolean favoris) {
        recetteRepository.setFavorisById(favoris, id);
    }


    // Existing methods...

    public List<Recette> findByFavoris(boolean favoris) {
        return recetteRepository.findByFavoris(favoris);
    }


}
