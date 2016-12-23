package io.bautista.service;

import io.bautista.model.Alumno;
import io.bautista.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alexis on 23/12/2016.
 */
@Service("AlumnoService")
@Transactional(readOnly = true)
public class AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Transactional(readOnly = false)
    public boolean addAlumno(Alumno al) throws Exception {
        Alumno old = alumnoRepository.findByAlCi(al.getAlCi());

        if (old != null) {
            throw new Exception("Ya existe alumno con este CI");
        }
        alumnoRepository.save(al);
        return true;

    }

    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }
}
