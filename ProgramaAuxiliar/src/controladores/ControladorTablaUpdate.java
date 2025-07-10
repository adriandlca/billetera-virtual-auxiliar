
package controladores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Transaccion;

public class ControladorTablaUpdate {
    private int contador;
    private DefaultTableModel ModeloTabla;
    private ArrayList<Transaccion> transacciones;

    public ControladorTablaUpdate(DefaultTableModel ModeloTabla, ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
        this.ModeloTabla = ModeloTabla;
    }
    
    public void ActualizarTabla(){
            for(int i=0;i<transacciones.size();i++){
                Transaccion transaccion = transacciones.get(i);
                DecimalFormat df2 = new DecimalFormat("####.00");
                String monto = df2.format(-transaccion.getMonto());
                Object[] fila = {i+1, transaccion.getNumTelefoNroCuenta(), transaccion.getFecha(), transaccion.getDescripcion(), monto};
                ModeloTabla.addRow(fila);
            }
    }
    
    public int getContador(){
        contador = transacciones.size();
        return contador;
    }
}
