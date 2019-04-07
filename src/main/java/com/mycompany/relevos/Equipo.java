package com.mycompany.relevos;

import java.util.Date;

/**
 * @param nombre es el nombre del equipo
 * @param inicial es la primera letra del equipo
 * @param posActual es la posicion inicial en la que comienza la carrera
 * @param posActual_2 es donde se hace el primer relevo (33)
 * @param posActual_3 es donde se hace el segundo relevo (66)
 * @author Alejo02
 * @author Luna
 */
public class Equipo {
    private String nombre;
    private String inicial;
    private Date termino;
    private int posActual;
    private int posActual_2;
    private int posActual_3;
    
   /**
    * Constructor que recibe el nombre y la inicial del equipo
    * Inicializa las posiciones de la pista de carrera
    * @param nombre recibe el nombre del equipo
    * @param inicial recibe la inicial del equipo
    */
    public Equipo(String nombre, String inicial) {
        termino = null;
        this.nombre = nombre;
        this.inicial = inicial;
        this.posActual=0;
        this.posActual_2=33;
        this.posActual_3=66;
        
    }
   
    /**
     * Método sincronizado que concatena la impresion final
     * @return imprimir que es la variable concatenada
     */
    public synchronized String concatenarImpresion(){
        String imprimir="";
        imprimir = "\nTeam : " + inicial + " ";
        for (int i = 0; i <= 100; i++) {
            if (i == posActual) {
                imprimir += "*";
            } else if (i == posActual_2) {
                imprimir += "#";
            } else if (i == posActual_3) {
                imprimir += "+";
            } else {
                imprimir += ".";
            }
        } 
        return imprimir;
    }

    /**
     * Getters y setters
     * @return 
     */
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

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }
    
}
