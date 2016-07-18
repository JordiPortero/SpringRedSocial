package com.example.service;

import com.example.domain.Amistad;
import com.example.domain.Pareja;
import com.example.domain.Persona;
import com.example.repository.AmistadRepository;
import com.example.repository.ParejaRepository;
import com.example.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by professor on 14/07/2016.
 */
@Service
@Transactional
public class SocialNetworkService {
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ParejaRepository parejaRepository;
    @Autowired
    private AmistadRepository amistadRepository;

    //API publico de la rede social.
    public void addPersona(Persona persona) {
        personaRepository.save(persona);
    }

    public void añadirpareja(Persona p1, Persona p2) {
        Pareja pareja = new Pareja(p1, p2);
        parejaRepository.save(pareja);

    }


    public Persona getPersona(Long id) {
        return personaRepository.findOne(id);
    }

    public Persona getPersona(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    public Persona getPareja(Persona persona) {
        Pareja pareja = parejaRepository.getPareja(persona);
        Persona resultado = null;
        if (pareja == null) {
            return resultado;
        } else {
            if (pareja.getP1().equals(persona)) {
                resultado = pareja.getP2();
            } else {
                if (pareja.getP2().equals(persona)) {
                    resultado = pareja.getP1();
                }
            }

        }
        return resultado;

    }
    public Amistad addAmistades(Persona persona1, Persona persona2){
        //TODO: gestionar el posible error de que estas 2 personas ya sean amigos.

        return amistadRepository.save(new Amistad(persona1, persona2));//Queremos añadir la nueva amistad, pero también queremos
        // mostrar el id generado por la BD.
    }

    public List<Persona> getAmistades(Persona persona) {
        List<Amistad> amistades = amistadRepository.getAmistades(persona);
        List<Persona> resultado = new ArrayList<>();//lo inicializo a un new arraylist pk

        for (Amistad amistad : amistades) {
            if (amistad.getPersona1().equals(persona)) {
                resultado.add(amistad.getPersona2());
            } else if (amistad.getPersona2().equals(persona)) {
                resultado.add(amistad.getPersona1());
            }
        }
        //hemos hecho lo mismo que con pareja.
        return resultado; //el return resultado sera el list de personas que son todos los amigos.
    }
}
