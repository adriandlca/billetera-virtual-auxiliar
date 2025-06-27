/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class EscribirArchivoTransacciones {
    
    public void EscribirArchivo(int numTelefoNroCuenta,String fecha, double monto, String Descripcion, String tipoTransaccion){
        try{
            FileWriter fw = new FileWriter("Transacciones.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(numTelefoNroCuenta+","+fecha+","+monto+","+Descripcion+","+tipoTransaccion);
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la lectura dle archivo...");
        }    
    }
    
}
