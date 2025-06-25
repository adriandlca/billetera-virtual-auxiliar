/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class EscribirArchivoTransacciones {
    private int numTelefoNroCuenta;
    private int monto;
    private String Descripcion;
    private String tipoTransaccion;

    public EscribirArchivoTransacciones(int numTelefoNroCuenta, int monto, String Descripcion, String tipoTransaccion) {
        this.numTelefoNroCuenta = numTelefoNroCuenta;
        this.monto = monto;
        this.Descripcion = Descripcion;
        this.tipoTransaccion = tipoTransaccion;
    }
    
    public void EscribirArchivo(){
        try{
            FileWriter fw = new FileWriter("Transacciones.txt",true);
            PrintWriter pw = new PrintWriter(fw);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la lectura dle archivo...");
        }    
    }
    
}
