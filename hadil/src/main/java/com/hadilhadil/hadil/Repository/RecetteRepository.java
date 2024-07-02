package com.hadilhadil.hadil.Repository;

import com.hadilhadil.hadil.model.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RecetteRepository extends JpaRepository<Recette, Long> {
    List<Recette> findByChef_IdChef(Long chefId);
    List<Recette> findByFavoris(boolean favoris);
    @Modifying
    @Transactional
    @Query("UPDATE Recette r SET r.favoris = :favoris WHERE r.idRecette = :idRecette")
    void setFavorisById(@Param("favoris") boolean favoris, @Param("idRecette") Long idRecette);
}
