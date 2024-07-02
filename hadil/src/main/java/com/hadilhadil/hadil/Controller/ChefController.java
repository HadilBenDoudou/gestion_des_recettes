package com.hadilhadil.hadil.Controller;

import com.hadilhadil.hadil.Repository.ChefRepository;
import com.hadilhadil.hadil.model.Chef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chef")
public class ChefController {

    @Autowired
    private ChefRepository chefRepository;

    @PostMapping("/ajouterChef")
    public ResponseEntity<?> ajouterChef(@RequestBody Chef chef) {
        Chef existingChef = chefRepository.findByLogin(chef.getLogin());
        if (existingChef != null) {
            return new ResponseEntity<>(existingChef, HttpStatus.OK); // Retourne le chef existant
        }
        Chef savedChef = chefRepository.save(chef);
        return new ResponseEntity<>(savedChef, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getChefById(@PathVariable Long id) {
        Chef chef = chefRepository.findById(id).orElse(null);
        if (chef == null) {
            return new ResponseEntity<>("Chef introuvable", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chef, HttpStatus.OK);
    }
}
