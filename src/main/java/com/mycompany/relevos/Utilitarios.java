/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 * Clase para métodos que usa el software en diferentes clases
 * @author Alejo02
 * @author Luna
 */
public class Utilitarios {
    
    /**
     * Método que genera un numero entero random entre 0 y 3
     * @return 
     */
    public static int random(){
      
        return (int) Math.floor(Math.random()*(4*1));
     
    }
}
