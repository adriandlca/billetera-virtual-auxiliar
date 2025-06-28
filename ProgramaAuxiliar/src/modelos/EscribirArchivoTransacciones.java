/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EscribirArchivoTransacciones {
    private ArrayList<Transaccion> transacciones;
    
    public void EscribirArchivo(ArrayList<Transaccion> transacciones){
        try{
            this.transacciones = transacciones;
            FileWriter fw = new FileWriter("Transacciones.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(int i = 0; i<this.transacciones.size();i++){
                Transaccion transaccion = this.transacciones.get(i);
                pw.println(transaccion.getNumTelefoNroCuenta()+","+transaccion.getFecha()+","+transaccion.getMonto()+","+transaccion.getDescripcion()+","+transaccion.getTipoTransaccion());
            }
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la lectura dle archivo...");
        }    
    }
    
}
