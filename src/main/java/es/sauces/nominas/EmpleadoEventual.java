/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

/**
 *
 * @author cristian.matveg
 */
public class EmpleadoEventual extends Empleado{
    private float salarioHora;
    private int horas;

    public EmpleadoEventual() {
    }

    public EmpleadoEventual(String dni) {
        super(dni);
    }

    public EmpleadoEventual(float salarioHora, String dni, String nombre, int horas) {
        super(dni, nombre);
        this.salarioHora = salarioHora;
        this.horas = horas;
    }

    @Override
    public String toString() {
        return super.getNombre() + " " + super.getDni() + " " + this.ingresos();
    }

    @Override
    public float ingresos(){
        return (salarioHora*horas);
    }
    
}
