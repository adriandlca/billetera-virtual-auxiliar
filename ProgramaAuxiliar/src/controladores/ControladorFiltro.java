package controladores;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;
import modelos.Transaccion;
import vistas.JPantallaAuxiliar;


public class ControladorFiltro {
    private ArrayList<Transaccion> listaCopia;
    private DefaultTableModel ModeloTabla;
    private int contador =0;
    private JPantallaAuxiliar pantallaPrincipal;
    

    public ControladorFiltro(JPantallaAuxiliar pantallaPrincipal, ArrayList<Transaccion> listaOriginal, DefaultTableModel modeloTabla ) {
        this.listaCopia = new ArrayList<>(listaOriginal);
        this.ModeloTabla = modeloTabla;
        this.pantallaPrincipal = pantallaPrincipal;
        
    }
    
    //ACTUALIZAR TABLA
    void filtrarTabla(){
        ControladorVaciarTabla vaciarTabla = new ControladorVaciarTabla(ModeloTabla, pantallaPrincipal.getJTabla());
        ControladorTablaUpdate tablaUpdate = new ControladorTablaUpdate(ModeloTabla, listaCopia);
        tablaUpdate.ActualizarTabla();
    }
    
    // LOGICA DE FILTRADO
    public void sinFiltro(){
        ControladorVaciarTabla vaciarTabla = new ControladorVaciarTabla(ModeloTabla, pantallaPrincipal.getJTabla());
        ControladorTablaUpdate tablaUpdate = new ControladorTablaUpdate(ModeloTabla, pantallaPrincipal.getUsuario().getTransacciones());
        tablaUpdate.ActualizarTabla();
    }
    
    public void ordenarPorFechaReciente(){
        Collections.reverse(listaCopia);
        filtrarTabla();
    }
    
    public void ordenarPorMontoDesc(){
        Transaccion aux;
        for(int i=0;i<listaCopia.size()-1;i++){
            for(int j=0;j<listaCopia.size()-(i+1);j++){
                if(listaCopia.get(j).getMonto() > listaCopia.get(j+1).getMonto()){
                    aux = listaCopia.get(j);
                    listaCopia.set(j, listaCopia.get(j+1));
                    listaCopia.set(j+1, aux);
                }
            }
        }
        Collections.reverse(listaCopia);
        filtrarTabla();
    }
    
    public void ordenarPorMontoAsc(){
        Transaccion aux;
        for(int i=0;i<listaCopia.size()-1;i++){
            for(int j=0;j<listaCopia.size()-(i+1);j++){
                if(listaCopia.get(j).getMonto() > listaCopia.get(j+1).getMonto()){
                    aux = listaCopia.get(j);
                    listaCopia.set(j, listaCopia.get(j+1));
                    listaCopia.set(j+1, aux);
                }
            }
        }
        filtrarTabla();
    }
    
    public void ordenarPorNumeroTelefonico(){
       ArrayList ListaTelef = new ArrayList<>();
       for(Transaccion tr: listaCopia){
           if(tr.getTipoTransaccion().equalsIgnoreCase("telefono")){
               ListaTelef.add(tr);
           }
       }   
       ControladorVaciarTabla vaciarTabla = new ControladorVaciarTabla(ModeloTabla, pantallaPrincipal.getJTabla());
       ControladorTablaUpdate tablaUpdate = new ControladorTablaUpdate(ModeloTabla, ListaTelef);
       tablaUpdate.ActualizarTabla();
    }
    
    public void ordenarPorTransferencia(){
        ArrayList ListaTelef = new ArrayList<>();
       for(Transaccion tr: listaCopia){
           if(tr.getTipoTransaccion().equalsIgnoreCase("transferencia")){
               ListaTelef.add(tr);
           }
       }   
       ControladorVaciarTabla vaciarTabla = new ControladorVaciarTabla(ModeloTabla, pantallaPrincipal.getJTabla());
       ControladorTablaUpdate tablaUpdate = new ControladorTablaUpdate(ModeloTabla, ListaTelef);
       tablaUpdate.ActualizarTabla();
    }
  
}
