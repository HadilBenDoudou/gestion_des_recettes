package com.hadilhadil.hadil.model;

import jakarta.persistence.*;

@Entity
@Table(name = "date")
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_date") // Nom de la colonne dans la base de données
    private Long idDate;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur") // Nom de la colonne de clé étrangère dans la base de données
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_recette") // Nom de la colonne de clé étrangère dans la base de données
    private Recette recette;

    // Getter et Setter pour idDate
    public Long getIdDate() {
        return idDate;
    }

    public void setIdDate(Long idDate) {
        this.idDate = idDate;
    }

    // Getter et Setter pour utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    // Getter et Setter pour recette
    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }
}
