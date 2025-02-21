/*
 * Cristian Mateos Vega   DAW1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.nominas;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dni implements Comparable<Dni>{
    private String dni;
 
    private Dni(String dni) throws DniException {
        if(!esValido(dni)){
            throw new DniException("Formato DNI incorrecto");
        }
        this.dni = dni;
    }
    
    static boolean esValido(String dni){
        String pattern="([0-9]{8})([A-Z])";
        int posicion;
        boolean valido=false;
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(dni);
        if(m.matches()){
            posicion=Integer.parseInt(m.group(1))%23;
            valido=letras.charAt(posicion)==m.group(2).charAt(0);
        }
        return valido;
    }
 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.dni);
        return hash;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dni other = (Dni) obj;
        return Objects.equals(this.dni, other.dni);
    }
 
    @Override
    public String toString() {
        return "Dni{" + "dni=" + dni + '}';
    }
 
    public String getDni() {
        return dni;
    }
 
    public void setDni(String dni) throws DniException {
        if(!esValido(dni)){
        throw new DniException("Formato DNI incorrecto");
        }
        this.dni = dni;
    }
    @Override
    public int compareTo(Dni o) {
        return this.dni.compareTo(o.dni);
    }

    public static Dni valueOf(String dni) throws DniException {
        if(!esValido(dni)){
            throw new DniException("Formato DNI incorrecto");
        }
        return new Dni(dni);
    }
    
    
    
}