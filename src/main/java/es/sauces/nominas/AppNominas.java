/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.nominas;

import java.io.IOException;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @version 21
 * @author cristian.matveg
 */
public class AppNominas {

    private static final Logger LOG=Logger.getLogger("es.sauces.nominas");
    public static void main(String[] args) throws IOException {
        Empleado empleado = null;
        SistemaNominas sistema = new SistemaNominas();
        int opcion;
        String nombre;
        String dni;
        float salario, salarioHora;
        int horas;
        Scanner teclado = new Scanner(System.in);
        Handler controlador=new FileHandler("./registro.log,",true);
        controlador.setFormatter(new SimpleFormatter());
        LOG.addHandler(controlador);
        LogManager.getLogManager().readConfiguration(ClassLoader.getSystemClassLoader().getResourceAsStream("mylogging.properties"));

        do {
            System.out.println("1- Crear Empleado");
            System.out.println("2- Consultar Empleado");
            System.out.println("3- Eliminar Empleado");
            System.out.println("4- Listas Empleados");
            System.out.println("5- Listar Empleados por sueldo");
            System.out.println("6- Consultar total salarios");
            System.out.println("7- Listar Empleados por nombre");
            System.out.println("0- Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion >= 0 && opcion <= 7) {
                if (opcion == 1) {
                    System.out.println("1- Empleado Fijo");
                    System.out.println("2- Empleado Eventual");
                    opcion = teclado.nextInt();
                    teclado.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Introduzca DNI: ");
                            dni=teclado.nextLine();
                            System.out.print("Introduzca nombre: ");
                            nombre=teclado.nextLine();
                            try {
                            System.out.print("Introduzca salario: ");
                            salario=teclado.nextFloat();  
                            empleado=new EmpleadoFijo(Dni.valueOf(dni),nombre,salario);
                            if (sistema.incluirEmpleado(empleado)){
                                System.out.println("Empleado introducido correctamente.");
                            }
                            else{
                                System.out.println("ERROR");
                            }
                        } catch (DniException | IllegalArgumentException | InputMismatchException ex) {
                            System.out.println(ex.getMessage());
                        }finally{
                            teclado.nextLine();
                        }
                        }
                        case 2 -> {
                            System.out.print("Introduzca DNI: ");
                            dni=teclado.nextLine();
                            System.out.print("Introduzca nombre: ");
                            nombre=teclado.nextLine();
                            try {
                            System.out.print("Introduzca salario hora: ");
                            salario=teclado.nextFloat();
                            System.out.print("Introduzca horas: ");
                            horas=teclado.nextInt(); 
                            empleado=new EmpleadoEventual(Dni.valueOf(dni),nombre,salario,horas);
                             if (sistema.incluirEmpleado(empleado)){
                                System.out.println("Empleado introducido correctamente.");
                            }
                            else{
                                System.out.println("ERROR");
                            }
                        } catch (DniException | IllegalArgumentException | InputMismatchException ex) {
                            System.out.println(ex.getMessage());
                        }finally{
                            teclado.nextLine();
                        }

                        }
                    }
                } else {
                    switch (opcion) {
                        case 2 -> {
                            System.out.println("Introduzca DNI del empleado que quiere consultar");
                            dni = teclado.nextLine();
                            try {
                                empleado = sistema.getEmpleado(dni);
                                if (empleado != null) {
                                    System.out.println(empleado);
                                } else {
                                    System.out.println("No se encontro el empleado");
                                }
                            } catch (DniException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                        case 3 -> {
                            System.out.print("Introduzca DNI del empleado que quiere eliminar: ");
                            dni = teclado.nextLine();
                            try {
                                empleado = sistema.getEmpleado(dni);
                                if (sistema.eliminarEmpleado(empleado)) {
                                    System.out.println("Empleado eliminado");
                                } else {
                                    System.out.println("No se pudo eliminar el empleado, puede que no exista");
                                }
                            } catch (DniException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }

                        case 4 -> {
                            for (Empleado e : sistema.listarEmpleados()) {
                                System.out.println(e);
                            }
                        }

                        case 5 -> {
                            for (Empleado e : sistema.listarEmpleadosPorSueldo()) {
                                System.out.println(e);
                            }
                        }

                        case 6 -> {
                            if (sistema != null) {
                                System.out.println(sistema.getTotalSalarios());
                            } else {
                                System.out.println("No se puede obtener la informacion solicitada, puede que el sistema este vacio");
                            }
                        }
                        case 7 -> {
                            List<Empleado> listadoEmpleados = sistema.listarEmpleados();
                            listadoEmpleados.sort(new Comparator<Empleado>() {
                                @Override
                                public int compare(Empleado o1, Empleado o2) {
                                    return o1.getNombre().compareTo(o2.getNombre());
                                }
                            });
                            for (Empleado e : listadoEmpleados) {
                                System.out.println(e);
                            }

                        }
                    }
                }
            } else {
                System.out.println("Adios");
            }
        } while (opcion != 0);
    }
}
