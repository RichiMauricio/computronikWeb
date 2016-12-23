package io.bautista.rest;

import io.bautista.model.Alumno;
import io.bautista.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Alexis on 23/12/2016.
 */
@RestController
@RequestMapping("/api/v1")
public class AlumnoRController {

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping(value = "/alumnos", method = RequestMethod.GET)
    public List<Alumno> greeting() {
        return alumnoService.getAll();
    }

    @RequestMapping(value = "/alumno", method = RequestMethod.POST,consumes="application/json")
    public String saveAlumno(@RequestBody Alumno al) {
        try {
            alumnoService.addAlumno(al);
            return "xxx" + al.getAlCi();
        } catch (Exception ex) {
            return "error";
        }
    }
}
