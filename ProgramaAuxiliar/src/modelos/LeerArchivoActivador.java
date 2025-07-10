
package modelos;

import excepciones.LoadActivationFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LeerArchivoActivador {
    private String codigoActivador;
    
    public void leerArchivo() throws LoadActivationFileException{
        try{
           String linea;
           FileReader fr =new FileReader("../SimuladorDeProcesos/Activador.txt");
           BufferedReader br = new BufferedReader(fr);
           while((linea=br.readLine())!=null){
               StringTokenizer st = new StringTokenizer(linea);
               this.codigoActivador = st.nextToken();
           }
        }catch(IOException e){
            throw new LoadActivationFileException("El Activador no fue cargado de forma correcta");
        }
    }   

    public String getCodigoActivador() {
        return this.codigoActivador;
    }
}
