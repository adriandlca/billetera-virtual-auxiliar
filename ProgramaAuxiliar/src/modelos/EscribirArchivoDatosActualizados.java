/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP SUPPORT
 */
public class EscribirArchivoDatosActualizados {
    private ArrayList<Transaccion> transacciones;
    public void EscribirArchivo(ArrayList<Transaccion> transacciones, double saldo){      
        try{
            this.transacciones = transacciones;
            FileWriter fw = new FileWriter("DatosActualizados.txt");
            PrintWriter pw = new PrintWriter(fw);
            
            Transaccion transaccion = this.transacciones.get(this.transacciones.size()-1);
            pw.println(saldo+","+transaccion.getNumTelefoNroCuenta()+","+transaccion.getFecha()+","+transaccion.getMonto()+","+transaccion.getDescripcion()+","+transaccion.getTipoTransaccion());
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la lectura dle archivo...");
        }    
    }
    
}
