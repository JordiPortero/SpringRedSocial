package com.example.repository;

import com.example.domain.Pareja;
import com.example.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by professor on 14/07/2016.
 */
public interface ParejaRepository extends JpaRepository<Pareja,Long>{
   @Query("SELECT pareja from Pareja pareja where pareja.p1=:persona or pareja.p2=:persona")
    Pareja getPareja(@Param("persona") Persona persona);

}
