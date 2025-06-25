/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import modelos.Transaccion;


public class Usuario {
    private String nombre;
    private int numeroTelef;
    private double sueldo;
    private String PIN;
    private ArrayList<Transaccion> transacciones;
    
    public Usuario(String nombre, int numeroTelef, double sueldo, String PIN) {
        transacciones = new ArrayList<Transaccion>();
        this.nombre = nombre;
        this.numeroTelef = numeroTelef;
        this.sueldo = sueldo;
        this.PIN = PIN;
    }
    
    public void registrarTransaccion(int numTelefoNroCuenta, int monto, String Descripcion, String tipoTransaccion){
        Transaccion tra = new Transaccion(numTelefoNroCuenta,monto,Descripcion,tipoTransaccion);
        transacciones.add(tra);
    }
    
    public void mostrarUsuario(){
        System.out.println("nombre: "+this.nombre);
        System.out.println("numero de telefono: "+this.numeroTelef);
        System.out.println("sueldo: "+this.sueldo);
        System.out.println("PIN: "+this.PIN);
    }
}
