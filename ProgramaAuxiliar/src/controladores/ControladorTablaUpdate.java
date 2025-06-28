/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Transaccion;

public class ControladorTablaUpdate {
    public void ActualizarTabla(DefaultTableModel modeloTabla ,Transaccion transaccion, int contador){
            contador++;
            DecimalFormat df2 = new DecimalFormat("####.00");
            String monto = df2.format(-transaccion.getMonto());
            Object[] fila = {contador, transaccion.getNumTelefoNroCuenta(), transaccion.getFecha(), transaccion.getDescripcion(), monto};
            modeloTabla.addRow(fila);
    }
}
