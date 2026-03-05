package com.exemple.service;

import com.exemple.entites.Personne;

public class PersonneService extends AbstractFacade<Personne>{

    public PersonneService() {
        super(Personne.class);
    }
}