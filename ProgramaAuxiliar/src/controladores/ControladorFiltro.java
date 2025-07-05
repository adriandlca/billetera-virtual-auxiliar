package controladores;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Transaccion;
import vistas.JPantallaAuxiliar;


public class ControladorFiltro {
    private ArrayList<Transaccion> listaFiltrada;
    private DefaultTableModel ModeloTabla;
    private int contador =0;
    private JPantallaAuxiliar pantallaPrincipal;
    

    public ControladorFiltro(JPantallaAuxiliar pantallaPrincipal, ArrayList<Transaccion> ListaOriginal, DefaultTableModel modeloTabla ) {
        this.listaFiltrada = new ArrayList<>(ListaOriginal);
        this.ModeloTabla = modeloTabla;
        this.pantallaPrincipal = pantallaPrincipal;
    }
    
    public void ninguno(){
        ControladorVaciarTabla vaciarTabla = new ControladorVaciarTabla(ModeloTabla, pantallaPrincipal.getJTabla());
        ControladorTablaUpdate tablaUpdate = new ControladorTablaUpdate(ModeloTabla, pantallaPrincipal.getUsuario().getTransacciones());
    }
    
    public void masRecientes(){
        ControladorVaciarTabla vaciarTabla = new ControladorVaciarTabla(ModeloTabla, pantallaPrincipal.getJTabla());
        
    }
    
    /**
    public void masAntiguo(){
            for(int i=listaFiltrada.size()-1;i>=0;i--){
                Transaccion tr = listaFiltrada.get(i);
                Transaccion transaccion = listaFiltrada.get(i);
                DecimalFormat df2 = new DecimalFormat("####.00");
                String monto = df2.format(-transaccion.getMonto());
                Object[] fila = {contador+1, listaFiltrada.getNumTelefoNroCuenta(), listaFiltrada.getFecha(), listaFiltrada.getDescripcion(), monto};
                modeloTabla.addRow(fila);
                contador++;
            }
    }
    
    public void masReciente(ArrayList<Transaccion> transacciones, DefaultTableModel modeloTabla){
            for(int i=transacciones.size()-1;i>=0;i--){
                Transaccion transaccion = transacciones.get(i);
                DecimalFormat df2 = new DecimalFormat("####.00");
                String monto = df2.format(-transaccion.getMonto());
                Object[] fila = {contador, transaccion.getNumTelefoNroCuenta(), transaccion.getFecha(), transaccion.getDescripcion(), monto};
                modeloTabla.addRow(fila);
                contador++;
            }
    }
    */
    
    
}
