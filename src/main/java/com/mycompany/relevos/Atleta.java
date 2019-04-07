package com.mycompany.relevos;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Alejo02
 * @author Luna
 */
public class Atleta extends Thread{
    Equipo equipo;
    private String nombre;
    private int posIni;
    private int posFinal;
    
    public Atleta(String nombre, int posisionInicial, int posicionFinal, Equipo equipo) {
        this.nombre = nombre;
        this.posIni = posisionInicial;
        this.posFinal = posicionFinal;
        this.equipo = equipo;
    }
    
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
    
    public void dormirHilo(){
        synchronized (equipo) {
            try {
                equipo.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
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
   
    public void imprimir(){
        if(equipo.concatenarImpresion().contains("R")){
            String rojo=equipo.concatenarImpresion();
            if(rojo!=null){
                System.out.println(rojo);
            }
        }else if(equipo.concatenarImpresion().contains("A")){
            String azul=equipo.concatenarImpresion();
            if(azul!=null){
                System.out.println(azul);
            }
        }else if(equipo.concatenarImpresion().contains("V")){
            String verde=equipo.concatenarImpresion();
            if(verde!=null){
                System.out.println(verde);
            }
        }
    }
}
