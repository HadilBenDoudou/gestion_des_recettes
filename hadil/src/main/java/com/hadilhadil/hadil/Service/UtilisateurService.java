package com.hadilhadil.hadil.Service;

import com.hadilhadil.hadil.Repository.UtilisateurRepository;
import com.hadilhadil.hadil.model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur validateUser(String login, String pwd) {
        return utilisateurRepository.findByLoginAndPwd(login, pwd);
    }


    public Optional<Utilisateur> findById(Long id) {
        return utilisateurRepository.findById(id);
    }
}
