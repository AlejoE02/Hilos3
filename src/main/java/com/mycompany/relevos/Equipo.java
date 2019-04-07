package com.mycompany.relevos;


/**
 * @param nombre es el nombre del equipo
 * @param inicial es la primera letra del equipo
 * @param posActual es la posicion inicial en la que comienza la carrera
 * @author Alejo02
 * @author Luna
 */
public class Equipo {
    private String nombre;
    private String inicial;
    
    private int posActual;
    
   /**
    * Constructor que recibe el nombre y la inicial del equipo
    * Inicializa las posiciones de la pista de carrera
    * @param nombre recibe el nombre del equipo
    * @param inicial recibe la inicial del equipo
    */
    public Equipo(String nombre, String inicial) {
        this.nombre = nombre;
        this.inicial = inicial;
        this.posActual=0;

    }
   
    /**
     * Método sincronizado que concatena la impresion final
     * @return imprimir que es la variable concatenada
     */
    
    public synchronized String concatenarImpresion(){
        String imprimir="";
        imprimir = "\nTeam : " + inicial + " ";
        for (int i = 0; i <= 100; i++) {
            if (i == 33) {
                imprimir += "*";
            } else if (i == 66) {
                imprimir += "*";
            } else if (i == posActual) {
                imprimir += "*°";
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

    
}
