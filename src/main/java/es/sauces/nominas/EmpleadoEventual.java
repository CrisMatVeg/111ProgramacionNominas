/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian.matveg
 */
public class EmpleadoEventual extends Empleado {

    private float salarioHora;
    private int horas;
    private static final Logger LOG = Logger.getLogger(EmpleadoEventual.class.getName());

    public EmpleadoEventual() {
    }

    public EmpleadoEventual(Dni dni) throws DniException {
        super(dni);
    }

    public EmpleadoEventual(Dni dni, String nombre, float salarioHora, int horas) throws DniException {
        super(dni, nombre);
        if (salarioHora < 0) {
            LOG.log(Level.WARNING,"El salario no puede ser negativo: {0}",salarioHora);
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + salarioHora + " | " + horas + " (" + this.ingresos() + ")";
    }

    @Override
    public float ingresos() {
        return (salarioHora * horas);
    }

}
