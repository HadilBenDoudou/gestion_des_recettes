package com.hadilhadil.hadil.Service;

import com.hadilhadil.hadil.Repository.ChefRepository;
import com.hadilhadil.hadil.model.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefService {

    @Autowired
    private ChefRepository chefRepository;
    public boolean loginExists(String login) {
        return chefRepository.existsByLogin(login);
    }

    public Chef ajouterChef(Chef chef) {
        return chefRepository.save(chef);
    }
    public List<Chef> getAllChefs() {
        return chefRepository.findAll();
    }

    public Chef getChefById(Long id) {
        return chefRepository.findById(id).orElse(null);
    }

    public Chef createChef(Chef chef) {
        return chefRepository.save(chef);
    }

    public Chef updateChef(Long id, Chef chefDetails) {
        Chef chef = chefRepository.findById(id).orElse(null);
        if (chef != null) {
            chef.setNom(chefDetails.getNom());
            chef.setSpecialite(chefDetails.getSpecialite());
            chef.setLogin(chefDetails.getLogin());
            return chefRepository.save(chef);
        }
        return null;
    }

    public void deleteChef(Long id) {
        chefRepository.deleteById(id);
    }
}
