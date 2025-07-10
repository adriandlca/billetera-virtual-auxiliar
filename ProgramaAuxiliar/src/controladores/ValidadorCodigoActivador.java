/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import excepciones.ActivationFileReadException;

public class ValidadorCodigoActivador {

    public boolean validarActivacion(String codigoActivador) throws ActivationFileReadException{
        if(!"1".equals(codigoActivador)){
            throw new ActivationFileReadException(" El programa solo se ejecutará si los servidores del programa principal colapsen");
        }
        return true;
    }
}
