package com.hadilhadil.hadil.model;

import jakarta.persistence.*;

@Entity
@Table(name = "chef")
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chef")
    private Long idChef;

    @Column(name = "nom")
    private String nom;

    @Column(name = "specialite")
    private String specialite;

    @Column(name = "login")
    private String login;

    @Column(name = "pwd") // Ajout de la colonne pwd dans la base de données
    private String pwd; // Nouvelle propriété pwd

    // Getter et Setter pour idChef
    public Long getIdChef() {
        return idChef;
    }

    public void setIdChef(Long idChef) {
        this.idChef = idChef;
    }

    // Getter et Setter pour nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour specialite
    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    // Getter et Setter pour login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // Getter et Setter pour pwd
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setId(Long id) {
        this.idChef=id;
    }
}
