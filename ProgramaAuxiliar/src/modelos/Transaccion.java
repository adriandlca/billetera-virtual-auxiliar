
package modelos;

public class Transaccion {
    
    private int numTelef;
    private int monto;
    private String Descripcion;

    public Transaccion(int numTelef, int monto, String Descripcion) {
        this.numTelef = numTelef;
        this.monto = -monto;
        this.Descripcion = Descripcion;
    }
    
    
}
