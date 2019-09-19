/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.relevoscarrera;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angie Manrique
 */
public class Corredor extends Thread {

    private int posicion;

    private Carril carril;
    private int pasos;

    private String carriluno;
    private String carrildos;
    private String carriltres;

    public Corredor(int posicion, Carril carril) {
        this.posicion = posicion;
        this.carril = carril;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Carril getCarril() {
        return carril;
    }

    public void setCarril(Carril carril) {
        this.carril = carril;
    }

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

    public int cantidadPasos() {
        pasos = (int) (Math.random() * 3 + 1);
        return pasos;
    }

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

            }
        }
    }

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
