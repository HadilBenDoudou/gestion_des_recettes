package com.hadilhadil.hadil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur") // Nom de la colonne dans la base de données
    private Long idUtilisateur;

    @Column(name = "nom") // Nom de la colonne dans la base de données
    private String nom;

    @Column(name = "prenom") // Nom de la colonne dans la base de données
    private String prenom;

    @Column(name = "pwd") // Nom de la colonne dans la base de données
    private String pwd;

    @Column(name = "login") // Nom de la colonne dans la base de données
    private String login;

    // Getter et Setter pour idUtilisateur
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    // Getter et Setter pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Getter et Setter pour pwd
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    // Getter et Setter pour login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return idUtilisateur;
    }
}
