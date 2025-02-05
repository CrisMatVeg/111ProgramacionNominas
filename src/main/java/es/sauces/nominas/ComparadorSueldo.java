/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

import java.util.Comparator;

/**
 *
 * @author cristian.matveg
 */
public class ComparadorSueldo implements Comparator<Empleado> {

    @Override
    public int compare(Empleado e1, Empleado e2) {
        return Float.compare(e1.ingresos(), e2.ingresos());
    }

}
