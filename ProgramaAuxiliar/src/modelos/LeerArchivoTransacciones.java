
package modelos;

import excepciones.LoadActivationFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class LeerArchivoTransacciones {
    private int NroTrasaccionOTelef;
    private double monto;
    private String descripcion;
    
    public void leerArchivo() throws LoadActivationFileException{
        try{
           String linea;
           FileReader fr =new FileReader("Transacciones.txt");
           BufferedReader br = new BufferedReader(fr);
           while((linea=br.readLine())!=null){
               StringTokenizer st = new StringTokenizer(linea);
               
           }
        }catch(IOException e){
            throw new LoadActivationFileException("El archivo no fue cargado de forma correcta");
        }
    }
}
