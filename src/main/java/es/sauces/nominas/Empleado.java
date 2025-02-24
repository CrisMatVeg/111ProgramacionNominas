/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian.matveg
 */
public abstract class Empleado implements Comparable<Empleado> {

    private Dni dni;
    private String nombre;
    private static final Logger LOG = Logger.getLogger(Empleado.class.getName());

    public Empleado() {
    }

    public Empleado(Dni dni) throws DniException {
        if(!Dni.esValido(dni.getDni())){
            throw new DniException("Dni Incorrecto");
        }
        this.dni = dni;
    }

    public Empleado(Dni dni, String nombre) throws DniException {
        if(!Dni.esValido(dni.getDni())){
            throw new DniException("Dni Incorrecto");
        }
        this.dni = dni;
        this.nombre = nombre;
    }

    public Dni getDni() {
        return dni;
    }

    public void setDni(Dni dni) throws DniException {
        if(!Dni.esValido(dni.getDni())){
            throw new DniException("Dni Incorrecto");
        }
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return dni + " | " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        return Objects.equals(this.dni, other.dni);
    }

    @Override
    public int compareTo(Empleado empleado) {
        return this.dni.compareTo(empleado.dni);
    }

    public abstract float ingresos();
}
