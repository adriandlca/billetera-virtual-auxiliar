
package modelos;

public class Transaccion {
    
    private String numTelefoNroCuenta;
    private String fecha;
    private double monto;
    private String Descripcion;
    private String tipoTransaccion;

    public Transaccion(String numTelefoNroCuenta, String fecha, double monto, String Descripcion, String tipoTransaccion) {
        this.numTelefoNroCuenta = numTelefoNroCuenta;
        this.fecha = fecha;
        this.monto = monto;
        this.Descripcion = Descripcion;
        this.tipoTransaccion = tipoTransaccion;
    }

    public String getNumTelefoNroCuenta() {
        return numTelefoNroCuenta;
    }

    public void setNumTelefoNroCuenta(String numTelefoNroCuenta) {
        this.numTelefoNroCuenta = numTelefoNroCuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
}
