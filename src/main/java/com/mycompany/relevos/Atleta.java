package com.mycompany.relevos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param equipo hace referencia al equipo registrado al atleta
 * @param nombre nombre del atleta
 * @param  posIni es la posicion en la que inicia el atleta
 * @author Alejo02
 * @author Luna
 */
public class Atleta extends Thread{
    Equipo equipo;
    private String nombre;
    private int posIni;

    
    /**
     * Constructor con las variables que componen el atleta
     * @param nombre nombre del atleta
     * @param posicionInicial posicion inicial del atleta
     * @param equipo nombre del equipo al que pertenece
     */
    public Atleta(String nombre, int posicionInicial, Equipo equipo) {
        this.nombre = nombre;
        this.posIni = posicionInicial;
        this.equipo = equipo;
    }
    
    /**
     * Metodo heredado de Thread para hilos
     */
    @Override
    public void run(){
        if (posIni == 0) {
            sumaAtleta(1);
        } else if(posIni ==33){
            sumaAtleta(2);
        }else if(posIni == 66){
            sumaAtleta(3);
        }else{
            dormirHilo();
        }
    }

    /**
     * Método que permite el avance del atleta
     * @param atleta recive el id del atleta
     */
    public void sumaAtleta(int atleta){
        while(true){
            if(atleta == 1){
                int pasoActual = suma();
                if (pasoActual >= 33) { 
                    synchronized (equipo) {
                        equipo.notifyAll();
                        //posIni = 33;
                    }
                    break;
                }
            }
            if(atleta == 2){
                int pasoActual = suma();
                if (pasoActual >= 66) {         
                    synchronized (equipo) {
                        equipo.notify();
                    }
                    break;
                }
            }
            if(atleta == 3){
                int pasoActual = suma();
                if (pasoActual >= 100) {            
                    System.out.println(equipo.getNombre()+" Llegó a la meta primero");
                    System.exit(0);
                }
            }
        }
    }
    /**
     * Método que hace que el atleta espere si es necesario 
     */
    public void dormirHilo(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Metodo que le suma al atleta segun un random de 0 a 3
     * @return posicion del atleta 
     */
    public int suma() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Utilitarios.random();
       
        equipo.setPosActual(equipo.getPosActual() + avance);
        imprimir();
        return equipo.getPosActual();
            
      }
   
    /**
     * Método para imprimir el equipo y sus posiciones
     * Llama al método concatenarImpresion que ayuda a imprimir
     */
    public void imprimir(){
        if(equipo.concatenarImpresion().contains("R")){
            System.out.println("\033[31m"+equipo.concatenarImpresion());
        }else if(equipo.concatenarImpresion().contains("A")){
            System.out.println("\033[34m"+equipo.concatenarImpresion());
        }else if(equipo.concatenarImpresion().contains("V")){
            System.out.println("\033[32m"+equipo.concatenarImpresion());
        }
    }

    /**
     * Getters y Setters
     * @return 
     */
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosIni() {
        return posIni;
    }

    public void setPosIni(int posIni) {
        this.posIni = posIni;
    }
}
