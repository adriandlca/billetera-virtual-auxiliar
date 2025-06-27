/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import modelos.Transaccion;


public class Usuario {
    private String nombre;
    private int numeroTelef;
    private double saldo;
    private String PIN;
    private ArrayList<Transaccion> transacciones;
    
    public Usuario(String nombre, int numeroTelef, double sueldo, String PIN) {
        transacciones = new ArrayList<Transaccion>();
        this.nombre = nombre;
        this.numeroTelef = numeroTelef;
        this.saldo = sueldo;
        this.PIN = PIN;
    }
    
    public void registrarTransaccion(int numTelefoNroCuenta, double monto, String Descripcion, String tipoTransaccion){
        LocalDateTime fechahora = LocalDateTime.now();
        String tiempoAhora = String.valueOf(fechahora);
        Transaccion tra = new Transaccion(numTelefoNroCuenta,tiempoAhora,monto,Descripcion,tipoTransaccion);
        transacciones.add(tra);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroTelef() {
        return numeroTelef;
    }

    public void setNumeroTelef(int numeroTelef) {
        this.numeroTelef = numeroTelef;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
    
    
   
    
}
