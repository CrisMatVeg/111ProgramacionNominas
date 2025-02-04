/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

/**
 *
 * @author cristian.matveg
 */
public class EmpleadoFijo extends Empleado{
    private float salario;

    public EmpleadoFijo() {
    }

    public EmpleadoFijo(String dni) {
        super(dni);
    }

    public EmpleadoFijo(float salario, String dni, String nombre) {
        super(dni, nombre);
        this.salario = salario;
    }

    @Override
    public String toString() {
        return super.getNombre() + " " + super.getDni() + " " + salario;
    }

    @Override
    public float ingresos(){
        return salario;   
    }
    
}
