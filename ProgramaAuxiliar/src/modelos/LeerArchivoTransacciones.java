
package modelos;

import excepciones.LoadActivationFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class LeerArchivoTransacciones {
    private String NroTrasaccionOTelef;
    private String fecha;
    private double monto;
    private String descripcion;
    private String tipoTransaccion;
    
    public void leerArchivo(Usuario user) throws LoadActivationFileException{
        try{
           String linea;
           FileReader fr =new FileReader("Transacciones.txt");
           BufferedReader br = new BufferedReader(fr);
           while((linea=br.readLine())!=null){
               StringTokenizer st = new StringTokenizer(linea,",");
               NroTrasaccionOTelef = st.nextToken();
               fecha = st.nextToken();
               monto = Double.parseDouble(st.nextToken());
               descripcion = st.nextToken().trim();
               tipoTransaccion = st.nextToken();
               user.registrarTransaccion(NroTrasaccionOTelef, fecha, monto, descripcion, tipoTransaccion);
           }
           
        }catch(IOException e){
            throw new LoadActivationFileException("El archivo no fue cargado de forma correcta");
        }
    }
}
