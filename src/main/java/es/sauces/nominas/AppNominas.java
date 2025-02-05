/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.nominas;

import java.util.Scanner;

/**
 * @version 21
 * @author cristian.matveg
 */
public class AppNominas {

    public static void main(String[] args) {
        Empleado empleado = null;
        SistemaNominas sistema;
        int opcion;
        sistema = new SistemaNominas();
        String nombre, dni;
        float salario, salarioHora;
        int horas;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("1- Crear Empleado");
            System.out.println("2- Consultar Empleado");
            System.out.println("3- Eliminar Empleado");
            System.out.println("4- Listas Empleados");
            System.out.println("5- Listar Empleados por sueldo");
            System.out.println("6- Consultar total salarios");
            System.out.println("0- Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion >= 1 && opcion <= 6) {
                if (opcion == 1) {
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    System.out.print("Introduzca DNI: ");
                    dni = teclado.nextLine();
                    System.out.println("1- Empleado Fijo");
                    System.out.println("2- Empleado Eventual");
                    opcion = teclado.nextInt();
                    teclado.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Introduzca salario: ");
                            salario = teclado.nextFloat();
                            empleado = new EmpleadoFijo(dni, nombre, salario);
                        }
                        case 2 -> {
                            System.out.print("Introduzca salario por hora: ");
                            salarioHora = teclado.nextFloat();
                            System.out.print("Introduzca horas: ");
                            horas = teclado.nextInt();
                            empleado = new EmpleadoEventual(dni, nombre, horas, salarioHora);
                        }
                    }
                    if (sistema.incluirEmpleado(empleado)) {
                        System.out.println("Empleado añadido.");
                    } else {
                        System.out.println("El empleado no pudo ser añadido, puede que ya exista");
                    }
                } else {
                    switch (opcion) {
                        case 2 -> {
                            System.out.println("Introduzca DNI del empleado que quiere consultar");
                            dni = teclado.nextLine();
                            empleado = sistema.getEmpleado(dni);
                            if (empleado != null) {
                                System.out.println(empleado);
                            } else {
                                System.out.println("No se encontro el empleado");
                            }
                        }
                        case 3 -> {
                            System.out.print("Introduzca DNI del empleado que quiere eliminar: ");
                            dni = teclado.nextLine();
                            empleado = sistema.getEmpleado(dni);
                            if (sistema.eliminarEmpleado(empleado)) {
                                System.out.println("Empleado eliminado");
                            } else {
                                System.out.println("No se pudo eliminar el empleado, puede que no exista");
                            }
                        }

                        case 4 -> {
                            for(Empleado e: sistema.listarEmpleados()){
                                 System.out.println(e);
                            }
                        }

                        case 5 -> {
                            for(Empleado e: sistema.listarEmpleadosPorSueldo()){
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
                    }
                }
            } else {
                System.out.println("Adios");
            }
        } while (opcion != 0);
    }
}
