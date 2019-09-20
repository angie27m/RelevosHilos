/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase encapsula el objeto Corredor, que seran cada uno de los hilos.
 *
 * @author Angie Manrique Alisson Celeita
 */
public class Corredor extends Thread {

    //Esta variable corresponde a la posicion en el carril
    private int posicion;
    //Esta variable crea un objeto tipo Carril
    private Carril carril;
    //Esta variable es la cantidad de pasos que aumenta cada corredor
    private int pasos;
    //Variable de referencia para el carril 1
    private String carriluno;
    //Variable de referencia para el carril 2
    private String carrildos;
    //Variable de referencia para el carril 3
    private String carriltres;

    /**
     * El constructor se encarga de crear los objetos tipo Corredor
     *
     * @param posicion Esta variable contiene la posicion del corredor.
     * @param carril Esta variable contiene el objeto carril.
     */
    public Corredor(int posicion, Carril carril) {
        this.posicion = posicion;
        this.carril = carril;
    }
    public Corredor(){
        
    }
    /**
     * Metodo para obtener la posicion del corredor
     *
     * @return Retorna la posicion del corredor
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * Metodo para darle valor a la variable posicion.
     *
     * @param posicion
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * Metodo para obtener el carril del corredor
     *
     * @return Retorna el carril del corredor
     */
    public Carril getCarril() {
        return carril;
    }

    /**
     * Metodo para darle valor al objeto carril.
     *
     * @param carril
     */
    public void setCarril(Carril carril) {
        this.carril = carril;
    }

    /**
     * Metodo que arranca cada uno de los hilos y evalua la posición en la que
     * se encuentra el corredor.
     */
    @Override
    public void run() {
        if (posicion == 0) {
            correr1();
        } else {
            esperar();
        }
        if (posicion == 33) {
            correr2();
        } else {
            esperar();
        }
        if (posicion == 66) {
            correr3();
        } else {
            esperar();
        }
    }

    /**
     * Metodo que le da un valor randomico entre 1 y 3 a los pasos que da cada
     * corredor
     *
     * @return Retorna los pasos que debe dar el corredor
     */
    public int cantidadPasos() {
        pasos = (int) (Math.random() * 3 + 1);
        return pasos;
    }

    /**
     * Metodo que hace mover al corredor 1 y notifica cuando este termine.
     */
    public void correr1() {
        while (true) {
            int pos = correr(1);
            if (pos >= 33) {
                carril.setPosicion1(33);
                synchronized (carril) {
                    carril.notifyAll();
                    posicion = 33;
                }
                break;
            }
        }
    }

    /**
     * Metodo que hace mover al corredor 2 y notifica cuando este termine.
     */
    public void correr2() {
        while (true) {
            int pos = correr(2);
            if (pos >= 66) {
                carril.setPosicion2(66);
                synchronized (carril) {
                    carril.notify();
                }
                break;
            }
        }
    }

    /**
     * Metodo que hace mover al corredor 3 y notifica si gano la carrera.
     */
    public void correr3() {
        while (true) {
            int pos = correr(3);
            if (pos >= 100) {
                carril.setPosicion3(100);
                if (carril.getNombre().equals("Carril #1")) {
                    carril.setNombre("#1");
                } else if (carril.getNombre().equals("Carril #2")) {
                    carril.setNombre("#2");
                } else if (carril.getNombre().equals("Carril #3")) {
                    carril.setNombre("#3");
                }
                System.out.println("Carril ganador: " + carril.getNombre());
                System.exit(0);
                break;
                
            }
        }
    }

    /**
     * Metodo que recoge las posiciones de cada uno de los corredores.
     *
     * @param numCorredor Esta variable recibe el corredor
     * @return Retorna la posicion
     */
    public int correr(int numCorredor) {
        cantidadPasos();
        if (numCorredor == 1) {
            carril.setPosicion1(carril.getPosicion1() + pasos);
            mostrarCarriles();
            return carril.getPosicion1();
        }
        if (numCorredor == 2) {
            carril.setPosicion2(carril.getPosicion2() + pasos);
            mostrarCarriles();
            return carril.getPosicion2();
        }
        if (numCorredor == 3) {
            carril.setPosicion3(carril.getPosicion3() + pasos);
            mostrarCarriles();
            return carril.getPosicion3();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Este metodo hace que el hilo espere hasta que le llegue la notificacion.
     */
    public void esperar() {
        synchronized (carril) {
            try {
                carril.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Este metodo realiza las impresiones segun el carril.
     */
    public void mostrarCarriles() {
        if (carril.imprimirCarrera().contains("Carril #1")) {
            carriluno = carril.imprimirCarrera();
            if (carriluno != null) {
                System.out.println(carriluno);
            }
        } else if (carril.imprimirCarrera().contains("Carril #2")) {
            carrildos = carril.imprimirCarrera();
            if (carrildos != null) {
                System.out.println(carrildos);
            }
        } else if (carril.imprimirCarrera().contains("Carril #3")) {
            carriltres = carril.imprimirCarrera();
            if (carriltres != null) {
                System.out.println(carriltres);
            }
        }
    }
}
