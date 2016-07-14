package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Created by professor on 14/07/2016.
 */
@Service
public class SocialNetworkService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;

    public void addPersona(Persona persona){
        personaRepository.save(persona);
    }
    public void añadirpareja(Persona p1, Persona p2){
        Pareja pareja = new Pareja(p1,p2);
        parejaRepository.save(pareja);

    }


}

