/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TransacribirArchivoUsuario {
    Usuario user;
    
    public void EscribirArchivo(Usuario user){
        try{
            this.user = user;
            FileWriter fw = new FileWriter("Usuariodb.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(user.getNombre()+","+user.getNumeroTelef()+","+user.getSaldo()+","+user.getPIN());
            pw.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la lectura dle archivo...");
        }
    }
}
