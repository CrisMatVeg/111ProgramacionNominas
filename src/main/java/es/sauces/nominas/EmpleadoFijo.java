/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

/**
 *
 * @author cristian.matveg
 */
public class EmpleadoFijo extends Empleado {

    private float salario;

    public EmpleadoFijo() {
    }

    public EmpleadoFijo(Dni dni) throws DniException {
        super(dni);
    }

    public EmpleadoFijo(Dni dni, String nombre, float salario) throws DniException {
        super(dni, nombre);
        if (salario < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
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
