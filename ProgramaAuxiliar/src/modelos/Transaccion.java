
package modelos;

public class Transaccion {
    
    private int numTelefoNroCuenta;
    private int monto;
    private String Descripcion;
    private String tipoTransaccion;

    public Transaccion(int numTelefoNroCuenta, int monto, String Descripcion, String tipoTransaccion) {
        this.numTelefoNroCuenta = numTelefoNroCuenta;
        this.monto = -monto;
        this.Descripcion = Descripcion;
        this.tipoTransaccion = tipoTransaccion;
    }
}
