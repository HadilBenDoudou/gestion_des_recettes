package com.hadilhadil.hadil.Service;

// ChefExistException.java - Exception personnalisée pour gérer les cas où un chef avec le même login existe déjà
public class ChefExistException extends RuntimeException {

    public ChefExistException(String message) {
        super(message);
    }
}
