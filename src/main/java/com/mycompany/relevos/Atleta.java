package com.mycompany.relevos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param equipo hace referencia al equipo registrado al atleta
 * @param nombre nombre del atleta
 * @param  posIni es la posicion en la que inicia el atleta
 * @param posFinal es la posicion en la que termina el atleta
 * @author Alejo02
 * @author Luna
 */
public class Atleta extends Thread{
    Equipo equipo;
    private String nombre;
    private int posIni;
    private int posFinal;
    
    /**
     * Constructor con las variables que componen el atleta
     * @param nombre
     * @param posisionInicial
     * @param posicionFinal
     * @param equipo 
     */
    public Atleta(String nombre, int posisionInicial, int posicionFinal, Equipo equipo) {
        this.nombre = nombre;
        this.posIni = posisionInicial;
        this.posFinal = posicionFinal;
        this.equipo = equipo;
    }
    
    /**
     * Metodo heredado de Thread para hilos
     */
    @Override
    public void run(){
        if (posIni == 0) {
            sumaAtleta1();
        } else {
            dormirHilo();
        }
        if (posIni == 33) {
            sumaAtleta2();
        } else {
            dormirHilo();
        }
        if (posIni == 66) {
            sumaAtleta3();
        } else {
            dormirHilo();
        }
    }

    /**
     * Método que suma si el atleta se encuentra antes de la posicion 33
     */
    public void sumaAtleta1(){
        while (true) {
            int pasoActual = suma(1);
            if (pasoActual >= 33) {
                equipo.setPosActual(33);
                synchronized (equipo) {
                    equipo.notifyAll();
                    posIni = 33;
                }
                break;
            }
        }
    }
    
    /**
     * Método que suma si el atleta se encuentra antes de la posicion 66
     */
    public void sumaAtleta2(){
        while (true) {
            int pasoActual = suma(2);
            if (pasoActual >= 66) {
                equipo.setPosActual_2(66);
                synchronized (equipo) {
                    equipo.notify();
                }
                break;
            }
        }
    }
    /**
     * Método que suma si el atleta se encuentra antes de la posicion 100
     * Llega a la meta en este método
     */
    public void sumaAtleta3(){
        while (true) {
            int pasoActual = suma(3);
            if (pasoActual >= 100) {
                equipo.setPosActual_3(100);
                System.out.println(equipo.getNombre()+" Llegó a la meta primero");
                System.exit(0);
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
    public int suma(int numAtleta) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int avance = Utilitarios.random();
        if (numAtleta == 1) {
            equipo.setPosActual(equipo.getPosActual()+ avance);
            imprimir();
            return equipo.getPosActual();
        }
        if (numAtleta == 2) {
            equipo.setPosActual_2(equipo.getPosActual_2() + avance);
            imprimir();
            return equipo.getPosActual_2();
        }
        if (numAtleta == 3) {
            equipo.setPosActual_3(equipo.getPosActual_3()+ avance);
            imprimir();
            return equipo.getPosActual_3();
        }
        return 0;
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

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }
    
    
}
