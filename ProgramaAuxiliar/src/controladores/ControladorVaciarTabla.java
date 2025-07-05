/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorVaciarTabla {
    public ControladorVaciarTabla(DefaultTableModel modeloTabla, JTable tabla){
        int filas = tabla.getRowCount();
        for(int i=0; i<filas; i++){
            modeloTabla.removeRow(0);
        }
    }
}
