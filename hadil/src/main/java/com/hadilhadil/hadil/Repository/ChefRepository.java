package com.hadilhadil.hadil.Repository;

import com.hadilhadil.hadil.model.Chef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChefRepository extends JpaRepository<Chef, Long> {
    boolean existsByLogin(String login);
    Chef findByLogin(String login);
}
