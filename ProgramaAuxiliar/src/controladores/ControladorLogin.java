/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.InvalidPINException;

public class ControladorLogin {
    
    private String PINGuardado = "1234";
    
    public boolean validarPIN(String PINIngresado) throws InvalidPINException{
        if(!isPinValid(PINIngresado)){
            throw new InvalidPINException("El PIN debe poseer 4 digitos:");
        }
        return PINIngresado.equals(PINGuardado); // si son iguales retorna true;
    }
    
    private boolean isPinValid(String PINIngresado){
        return PINIngresado!=null && PINIngresado.length() == 4 ;
    }
}
