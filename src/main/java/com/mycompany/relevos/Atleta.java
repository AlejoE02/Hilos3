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
     * @param nombre
     * @param posicionInicial
     * @param equipo 
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
        } else {
            dormirHilo();
        }
        if (posIni == 33) {
            sumaAtleta(2);
        } else {
            dormirHilo();
        }
        if (posIni == 66) {
            sumaAtleta(3);
        } else {
            dormirHilo();
        }
    }

    /**
     * Método que suma si el atleta se encuentra antes de la posicion 33
     */
    public void sumaAtleta(int atleta){
        while(true){
            if(atleta == 1){
                int pasoActual = suma();
                if (pasoActual >= 33) { 
                    synchronized (equipo) {
                        equipo.notifyAll();
                        posIni = 33;
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
     * @param numAtleta al cual se le va sumar posiciones
     * @return 0
     */
    public int suma() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Utilitarios.random();
       
            equipo.setPosActual(equipo.getPosActual()+ avance);
            imprimir();
            return equipo.getPosActual();
            
      }
   
    /**
     * Método para imprimir el equipo y sus posiciones
     * Llama al método concatenarImpresion que ayuda a imprimir
     */
    public void imprimir(){
        if(equipo.concatenarImpresion().contains("R")){
            String rojo=equipo.concatenarImpresion();
            if(rojo!=null){
                System.out.println("\033[31m"+rojo);
            }
        }else if(equipo.concatenarImpresion().contains("A")){
            String azul=equipo.concatenarImpresion();
            if(azul!=null){
                System.out.println("\033[34m"+azul);
            }
        }else if(equipo.concatenarImpresion().contains("V")){
            String verde=equipo.concatenarImpresion();
            if(verde!=null){
                System.out.println("\033[32m"+verde);
            }
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
