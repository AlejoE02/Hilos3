package com.mycompany.relevos;

import java.util.Date;

/**
 * 
 * @author Alejo02
 * @author Luna
 */
public class Equipo {
    private String nombre;
    private String inicial;
    private Date termino;
    private int posicion;
    private int posActual;
    private int posActual_2;
    private int posActual_3;
    
   
    public Equipo(String nombre, String inicial) {
        termino = null;
        this.nombre = nombre;
        this.inicial = inicial;
        this.posActual=0;
        this.posActual_2=33;
        this.posActual_3=66;
        
    }
   
    public synchronized String concatenarImpresion(){
        String imprimir="";
        imprimir = "\nTeam : " + inicial + " ";
        for (int i = 0; i <= 100; i++) {
            if (i == posActual) {
                imprimir += "#";
            } else if (i == posActual_2) {
                imprimir += "*";
            } else if (i == posActual_3) {
                imprimir += "+";
            } else {
                imprimir += ".";
            }
        } 
        return imprimir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosActual() {
        return posActual;
    }

    public void setPosActual(int posActual) {
        this.posActual = posActual;
    }

    public int getPosActual_2() {
        return posActual_2;
    }

    public void setPosActual_2(int posActual_2) {
        this.posActual_2 = posActual_2;
    }

    public int getPosActual_3() {
        return posActual_3;
    }

    public void setPosActual_3(int posActual_3) {
        this.posActual_3 = posActual_3;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
}
