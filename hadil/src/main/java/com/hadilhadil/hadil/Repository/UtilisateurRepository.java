package com.hadilhadil.hadil.Repository;

import com.hadilhadil.hadil.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByLoginAndPwd(String login, String pwd);
}
