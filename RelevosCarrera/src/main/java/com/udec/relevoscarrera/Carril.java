/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

/**
 * Esta clase encapsula el objeto Carril.
 *
 * @author Angie Manrique. Alisson Celeita.
 */
public class Carril {

    //Posicion del primer corredor.

    private int posicion1 = 0;
    //Posicion del segundo corredor.
    private int posicion2 = 33;
    //Posicion del tercer corredor.
    private int posicion3 = 66;
    //Nombre del carril.
    private String nombre;
    //Color negro.
    public static final String RESET = "\u001B[0m";

    /**
     * Constructor, crea los objetos carril recibiendo el nombre del carril
     *
     * @param nombre Nombre del carril
     */
    public Carril(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el nombre del carril
     *
     * @return Retorna el nombre del carril
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para darle valor a la variable nombre.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la posicion del corredor1
     *
     * @return Retorna la posicion del corredor1
     */
    public int getPosicion1() {
        return posicion1;
    }

    /**
     * Metodo para darle valor a la variable posicion1.
     *
     * @param posicion1
     */
    public void setPosicion1(int posicion1) {
        this.posicion1 = posicion1;
    }

    /**
     * Metodo para obtener la posicion del corredor2
     *
     * @return Retorna la posicion del corredor2
     */
    public int getPosicion2() {
        return posicion2;
    }

    /**
     * Metodo para darle valor a la variable posicion2.
     *
     * @param posicion2
     */
    public void setPosicion2(int posicion2) {
        this.posicion2 = posicion2;
    }

    /**
     * Metodo para obtener la posicion del corredor3
     *
     * @return Retorna la posicion del corredor3
     */
    public int getPosicion3() {
        return posicion3;
    }

    /**
     * Metodo para darle valor a la variable posicion3.
     *
     * @param posicion3
     */
    public void setPosicion3(int posicion3) {
        this.posicion3 = posicion3;
    }

    /**
     * Metodo que llena el string para imprimir.
     *
     * @return Retorna el string con el carril.
     */
    public synchronized String imprimirCarrera() {
        int pos = 0;
        String puesto = "";
        puesto = RESET + "Pista : " + nombre;
        for (int i = 0; i <= 100; i++) {
            if (nombre.equals("Carril #1")) {
                pos = 0;
                if (i == posicion1 || i == posicion2 || i == posicion3) {
                    puesto += "\033[34m ¥";
                } else {
                    puesto += "_\033[34m";
                }
            } else if (nombre.equals("Carril #2")) {
                pos = 1;
                if (i == posicion1 || i == posicion2 || i == posicion3) {
                    puesto += "\033[35m ¥";
                } else {
                    puesto += "_\033[35m";
                }
            } else if (nombre.equals("Carril #3")) {
                pos = 2;
                if (i == posicion1 || i == posicion2 || i == posicion3) {
                    puesto += "\033[31m ¥";
                } else {
                    puesto += "_\033[31m";
                }
            }
        }
        return puesto;
    }
}
