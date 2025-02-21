/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author cristian.matveg
 */
public class SistemaNominas extends ComparadorSueldo {

    private final Set<Empleado> empleados;

    public SistemaNominas() {
        empleados = new TreeSet<>();
    }

    public boolean incluirEmpleado(Empleado empleado) throws DniException {
        return empleados.add(empleado);
    }

    public Empleado getEmpleado(String dni) throws DniException {
        for (Empleado e : empleados) {
            if (e.getDni().equals(Dni.valueOf(dni))) {
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
        List<Empleado> lista=new ArrayList<>(empleados);
        lista.sort(new ComparadorSueldo().reversed());
        return lista;
    }

    public float getTotalSalarios() {
        float acumulador = 0;
        for (Empleado e : empleados) {
            acumulador += (e.ingresos());
        }
        return acumulador;
    }
}
