/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author HP SUPPORT
 */
public class Usuario {
    private String nombre;
    private int numeroTelef;
    private double sueldo;
    private String PIN;

    public Usuario(String nombre, int numeroTelef, double sueldo, String PIN) {
        this.nombre = nombre;
        this.numeroTelef = numeroTelef;
        this.sueldo = sueldo;
        this.PIN = PIN;
    }
    
    public void mostrarUsuario(){
        System.out.println("nombre: "+this.nombre);
        System.out.println("numero de telefono: "+this.numeroTelef);
        System.out.println("sueldo: "+this.sueldo);
        System.out.println("PIN: "+this.PIN);
    }
}
