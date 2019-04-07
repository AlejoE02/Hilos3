/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.relevos;

/**
 * Clase donde se crean los objetos de equipos y atletas
 * @author Alejo02
 * @author Luna
 */
public class Principal {

    Equipo team1 = new Equipo("Rojo", "R");
    Equipo team2 = new Equipo("Azul", "A");
    Equipo team3 = new Equipo("Verde", "V");
    
    Atleta atleta1 = new Atleta("Corredor 1", 0, team1);
    Atleta atleta2 = new Atleta("Corredor 2", 33, team1);
    Atleta atleta3 = new Atleta("Corredor 3", 66, team1);
    Atleta atleta4 = new Atleta("Corredor 4", 0, team2);
    Atleta atleta5 = new Atleta("Corredor 5", 33, team2);
    Atleta atleta6 = new Atleta("Corredor 6", 66, team2);
    Atleta atleta7 = new Atleta("Corredor 7", 0, team3);
    Atleta atleta8 = new Atleta("Corredor 8", 33, team3);
    Atleta atleta9 = new Atleta("Corredor 9", 66, team3);

    
    /**
     * Se inicializan los hilos con cada atleta
     */
    public void inicializar(){
        atleta1.start();
        atleta2.start();
        atleta3.start();
        atleta4.start();
        atleta5.start();
        atleta6.start();
        atleta7.start();
        atleta8.start();
        atleta9.start();
    }

}
