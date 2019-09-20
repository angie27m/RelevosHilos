/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Este metodo ejecuta todos los hilos
 *
 * @author Angie Manrique Alisson Celeita
 */
public class Carrera {

    /**
     * En el constructor se crean los carriles de la carrera y los respectivos
     * hilos tambien se ejecutan los hilos.
     */
    public Carrera() {
        Carril carr1 = new Carril("Carril #1");
        Carril carr2 = new Carril("Carril #2");
        Carril carr3 = new Carril("Carril #3");

        Corredor corredor1 = new Corredor(0, carr1);
        Corredor corredor2 = new Corredor(33, carr1);
        Corredor corredor3 = new Corredor(66, carr1);
        Corredor corredor4 = new Corredor(0, carr2);
        Corredor corredor5 = new Corredor(33, carr2);
        Corredor corredor6 = new Corredor(66, carr2);
        Corredor corredor7 = new Corredor(0, carr3);
        Corredor corredor8 = new Corredor(33, carr3);
        Corredor corredor9 = new Corredor(66, carr3);

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
        corredor5.start();
        corredor6.start();
        corredor7.start();
        corredor8.start();
        corredor9.start();

    }

}
