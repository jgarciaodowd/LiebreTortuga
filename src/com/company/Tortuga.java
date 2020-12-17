package com.company;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tortuga extends Thread{

    private Random rd = new Random();
    private int casilla = 0;
    Liebre l;

    public int getCasilla() {
        return casilla;
    }

    public void setLiebre(Liebre l){
        this.l=l;
    }

    public int suceso() {
        //generamos un numero de 0 a 99
        int prob = rd.nextInt(100);
        //determinamos el suceso en base al numero anterior
        if (prob < 50) {
            System.out.println("Avance rápido");
            casilla += 3;
        } else if (prob < 20) {
            System.out.println("Resbalón");
            casilla -= 6;
        } else {
            System.out.println("Avance lento");
            casilla++;
        }
        //nos aseguramos de que casilla nunca sea menor de 0 ni mayor de 70
        if (casilla < 0) {
            casilla = 0;
        }
        if (casilla >= 70) {
            casilla = 70;
        }
        return casilla;
    }

    @Override
    public void run() {
        while (casilla < 70 && l.getCasilla()< 70) {
            try {
                sleep(100);
                suceso();
                if(casilla>=70){
                    System.out.println("T ganó la carrera");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
