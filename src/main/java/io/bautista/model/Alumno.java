package io.bautista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;

/**
 * Created by Alexis on 23/12/2016.
 */
@Entity
@Table(name = "alumno")
@Data
//@EqualsAndHashCode(exclude = {"cuentas"})
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "al_id", unique = true, nullable = false)
    private Integer alId;
    @Column(name = "al_nombre", nullable = false, length = 45)
    private String alNombre;
    @Column(name = "al_ci", nullable = false, length = 45)
    private String alCi;
}
