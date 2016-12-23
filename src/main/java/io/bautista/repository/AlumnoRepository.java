package io.bautista.repository;

import io.bautista.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by Alexis on 23/12/2016.
 */
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>, Serializable {

    Alumno findByAlCi(String alCi);

    @Query("select c from Alumno as c where c.alNombre like %?1")
    Alumno findByNombre(String nombre);
}
