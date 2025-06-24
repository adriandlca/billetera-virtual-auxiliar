
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class EscribirArchivoActivador {
    private String codigoActivador = "1";
    
    public void Activar(String archivo){
        try{
            FileWriter fw = new FileWriter(archivo);
            PrintWriter pw =  new PrintWriter(fw);
            pw.println(codigoActivador);
            pw.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al escribir el archivo...");
        }
    }
}
