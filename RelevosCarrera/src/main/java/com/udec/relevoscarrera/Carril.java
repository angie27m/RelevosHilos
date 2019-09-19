/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

/**
 *
 * @author angie
 */
public class Carril {

    private int posicion1 = 0;
    private int posicion2 = 33;
    private int posicion3 = 66;
    private String nombre;

    public Carril(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicion1() {
        return posicion1;
    }

    public void setPosicion1(int posicion1) {
        this.posicion1 = posicion1;
    }

    public int getPosicion2() {
        return posicion2;
    }

    public void setPosicion2(int posicion2) {
        this.posicion2 = posicion2;
    }

    public int getPosicion3() {
        return posicion3;
    }

    public void setPosicion3(int posicion3) {
        this.posicion3 = posicion3;
    }

    public synchronized String imprimirCarrera() {
        String puesto = "";
        puesto = "Pista : " + nombre;
        for (int i = 0; i <= 100; i++) {
            if (nombre.equals("Carril #1")) {
                if (i == posicion1) {
                    puesto += "\033[34m ¥";
                } else if (i == posicion2) {
                    puesto += "\033[34m ¥";
                } else if (i == posicion3) {
                    puesto += "\033[34m ¥";
                } else {
                    puesto += "_\033[34m";
                }
            } else if (nombre.equals("Carril #2")) {
                if (i == posicion1) {
                    puesto += "\033[35m ¥";
                } else if (i == posicion2) {
                    puesto += "\033[35m ¥";
                } else if (i == posicion3) {
                    puesto += "\033[35m ¥";
                } else {
                    puesto += "_\033[35m";
                }
            } else if (nombre.equals("Carril #3")) {
                if (i == posicion1) {
                    puesto += "\033[31m ¥";
                } else if (i == posicion2) {
                    puesto += "\033[31m ¥";
                } else if (i == posicion3) {
                    puesto += "\033[31m ¥";
                } else {
                    puesto += "_\033[31m";
                }
            }

        }
        //limpiar();
        return puesto;

    }

    public void limpiar() {
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }
}
