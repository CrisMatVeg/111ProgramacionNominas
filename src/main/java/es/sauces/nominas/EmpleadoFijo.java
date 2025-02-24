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
public class EmpleadoFijo extends Empleado {

    private float salario;
    private static final Logger LOG = Logger.getLogger(EmpleadoEventual.class.getName());

    public EmpleadoFijo() {
    }

    public EmpleadoFijo(Dni dni) throws DniException {
        super(dni);
    }

    public EmpleadoFijo(Dni dni, String nombre, float salario) throws DniException {
        super(dni, nombre);
        if (salario < 0) {
            LOG.log(Level.WARNING,"El salario no puede ser negativo: {0}",salario);
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + salario;
    }

    @Override
    public float ingresos() {
        return salario;
    }

}
