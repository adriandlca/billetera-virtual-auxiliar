/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.InvalidNroCuentaBancariaException;
import excepciones.InvalidValueMontoException;

public class ValidarDatosTransaccionPorTransferencia {
    public boolean validarNumeroCtaBancaria(String nroCuentaBanc) throws InvalidNroCuentaBancariaException{
        if(!nroCuentaBanc.matches("\\d+")){
            throw new InvalidNroCuentaBancariaException("Nose adminten carateres diferentes a los números");
        }
        if( nroCuentaBanc.length() < 13 || nroCuentaBanc.length() > 20 ){
            throw new InvalidNroCuentaBancariaException("El número de cuenta bancaria debe tener entre 13 y 20 digitos");
        }
        return true;
    }
    
    public boolean validarMonto(String monto, double saldo) throws InvalidValueMontoException{
        if(!monto.matches("\\d+")){
            throw new InvalidValueMontoException("Ingrese un numero telefónico adecuado");
        }
        double montoDouble = Double.parseDouble(monto);         
        if(montoDouble>saldo){
            throw new InvalidValueMontoException("El monto ingresado sobrepasa a su saldo actual");
        }
        return true;
    }
}
