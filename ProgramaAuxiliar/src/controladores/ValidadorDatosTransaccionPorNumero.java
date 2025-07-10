/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.InvalidNumberPhoneException;
import excepciones.InvalidValueMontoException;

public class ValidadorDatosTransaccionPorNumero {
    public boolean validaNumeroTelefonico(String numeroTelf) throws InvalidNumberPhoneException{
        if(!numeroTelf.matches("\\d+")){
            throw new InvalidNumberPhoneException("Nose adminten carateres diferentes a los números");
        }
        if( numeroTelf.length()!=9){
            throw new InvalidNumberPhoneException("El número de cuenta debe tener 9 digitos");
        }
        
        int numero = Integer.parseInt(numeroTelf);
        
        if(numero < 900000000 || numero > 999999999){
            throw new InvalidNumberPhoneException("Ingrese un numero telefónico adecuado");
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
