package com.hadilhadil.hadil.Controller;

import com.hadilhadil.hadil.Repository.RecetteRepository;
import com.hadilhadil.hadil.Service.RecetteService;
import com.hadilhadil.hadil.model.Recette;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recettes")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;
    @GetMapping
    public List <Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Recette> addRecette(@RequestBody Recette recette) {
        try {
            // Assurez-vous que l'ID du chef est valide
            if (recette.getChef() == null || recette.getChef().getIdChef() == null) {
                throw new IllegalArgumentException("L'ID du chef est requis pour ajouter une recette.");
            }

            // Enregistrez la recette avec le service
            Recette savedRecette = recetteService.save(recette);

            // Retournez la réponse avec la recette sauvegardée
            return ResponseEntity.ok(savedRecette);
        } catch (Exception e) {
            // Gérez les erreurs et retournez une réponse appropriée en cas d'erreur
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/chef/{idChef}")
    public ResponseEntity<List<Recette>> obtenirRecettesParChef(@PathVariable("idChef") Long idChef) {
        try {
            List<Recette> recettes = recetteService.obtenirRecettesParChef(idChef);
            return ResponseEntity.ok(recettes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @Autowired
    private RecetteRepository recetteRepository;
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimerRecette(@PathVariable Long id) {
        try {
            recetteRepository.deleteById(id);
            return new ResponseEntity<>("Recette supprimée avec succès.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erreur lors de la suppression de la recette.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable Long id, @RequestBody Recette updatedRecette) {
        try {
            Optional<Recette> optionalRecette = recetteService.findById(id);
            if (optionalRecette.isPresent()) {
                Recette existingRecette = optionalRecette.get();
                existingRecette.setNom(updatedRecette.getNom());
                existingRecette.setDescription(updatedRecette.getDescription());
                existingRecette.setInstruction(updatedRecette.getInstruction());
                existingRecette.setFavoris(updatedRecette.isFavoris());
                Recette savedRecette = recetteService.save(existingRecette);
                return ResponseEntity.ok(savedRecette);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PutMapping("/{id}/favori")
    public ResponseEntity<Recette> updateFavori(@PathVariable Long id, @RequestParam boolean favori) {
        Optional<Recette> recetteOptional = recetteService.findById(id);
        if (!recetteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Recette recette = recetteOptional.get();
        recette.setFavoris(favori);
        recetteService.save(recette);

        return ResponseEntity.ok(recette);
    }
    @GetMapping("/favoris")
    public List<Recette> getFavoriteRecettes() {
        return recetteService.findByFavoris(true);
    }



    // Autres méthodes pour gérer les recettes (ex: findById, findAll, delete, etc.)
}
