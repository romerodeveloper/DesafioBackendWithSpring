package com.alura.desafio.repository;

import com.alura.desafio.model.Cancion;
import com.alura.desafio.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CantanteRepository extends JpaRepository<Cantante, Long> {
    Cantante findByNombreContainingIgnoreCase(String nombreCantante);

    @Query("SELECT canci FROM Cantante cantan JOIN cantan.canciones canci WHERE cantan = :cantante ORDER BY canci.nombre DESC LIMIT 5 ")
    List<Cancion> CancionesPorCantante(Cantante cantante);
}
