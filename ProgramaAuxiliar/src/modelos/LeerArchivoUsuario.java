/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import excepciones.LoadUserFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class LeerArchivoUsuario {
    private Usuario user;
    private String nombre;
    private int numeroTelef;
    private double sueldo;
    private String PIN;
    
    public void leerArchivo() throws LoadUserFileException{
        try{
           String linea;
           FileReader fr =new FileReader("Usuariodb.txt");
           BufferedReader br = new BufferedReader(fr);
           while((linea=br.readLine())!=null){
               StringTokenizer st = new StringTokenizer(linea,",");
               nombre = st.nextToken().trim();//SE USA EL TRIM() {IGNORA LOS ESPACIOS EN BLANCO} 
               /**PORQUE AL HABER ESPACIOS EN BLANCO EL TOKEN DETECTA UN ERROR POR LA DIVISIÓN DE LAS PALABRAS
               * EL TOKENIZER SOLO FUNCIONARÁ BIEN SI SOLO EXISTE LOS DELIMITADORES ADECUADOSS Y NO ESPCAIOS
               * MÁS INFO DEL METODO EN https://codegym.cc/es/groups/posts/es.1070.stringtokenizer-en-java DEL STRINGTOKENIZER
               * MÁS INFO PARA TRIM EN https://www.w3api.com/Java/String/trim/
               * IGNORAR PROVOCA EL ERROR DE LA VARIABLE numeroTelef, pero el error erradica en la variable nombre.
              **/
               numeroTelef = Integer.parseInt(st.nextToken());
               sueldo = Double.parseDouble(st.nextToken());
               PIN = st.nextToken();
               user = new Usuario(nombre,numeroTelef,sueldo,PIN);
               //user.mostrarUsuario(); -> solo para ver que se ejecte sin problemas
           }
        }catch(IOException e){
            throw new LoadUserFileException("No se cargó de manera correcta");
        }
        
        
     
    }   
}
