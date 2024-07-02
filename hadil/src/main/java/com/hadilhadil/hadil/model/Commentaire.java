package com.hadilhadil.hadil.model;

import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commentaire") // Nom de la colonne dans la base de données
    private Long idCommentaire;

    @Column(name = "contenu") // Nom de la colonne dans la base de données
    private String contenu;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur") // Nom de la colonne de clé étrangère dans la base de données
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_recette") // Nom de la colonne de clé étrangère dans la base de données
    private Recette recette;

    // Getter et Setter pour idCommentaire
    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    // Getter et Setter pour contenu
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Getter et Setter pour utilisateur
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    // Ajoutez un getter pour l'ID de l'utilisateur
    public Long getUtilisateurId() {
        return this.utilisateur != null ? this.utilisateur.getId() : null;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    // Getter et Setter pour recette
    // Getter et Setter pour recette
    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }


}
