/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cristian.matveg
 */
public class SistemaNominas extends ComparadorSueldo {

    private List<Empleado> empleados;
    private ComparadorSueldo comparadors;

    public SistemaNominas() {
        empleados = new LinkedList<>();
    }

    public boolean incluirEmpleado(Empleado empleado) {
        if (!empleados.contains(empleado) && empleado != null) {
            return empleados.add(empleado);
        }
        return false;
    }

    public Empleado getEmpleado(String dni) {
        for (Empleado e : empleados) {
            if(e.getDni().equals(dni)){
                return e;
            }
        }
        return null;
    }

    public boolean eliminarEmpleado(Empleado empleado) {
        return empleados.remove(empleado);
    }

    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }

    public List<Empleado> listarEmpleadosPorSueldo() {
        return new ArrayList<>(empleados);
    }

    public float getTotalSalarios() {
        float acumulador = 0;
        for (Empleado e : empleados) {
            acumulador += (empleados.get(empleados.indexOf(e))).ingresos();
        }
        return acumulador;
    }
}
