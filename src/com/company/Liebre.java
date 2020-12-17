package com.company;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Liebre extends Thread {

    private Random rd = new Random();
    private int casilla = 0;
    Tortuga t;

    public int getCasilla() {
        return casilla;
    }
    public void setTortuga(Tortuga t){
        this.t=t;
    }

    public int suceso() {
        //generamos un numero de 0 a 99
        int prob = rd.nextInt(100);
        //determinamos el suceso en base al numero anterior
        if (prob < 20) {
            System.out.println("Duerme");
        } else if (prob < 20) {
            System.out.println("Gran salto");
            casilla += 9;
        } else if(prob<10){
            System.out.println("Resbalón grande");
            casilla-=12;
        } else if(prob<30){
            System.out.println("Salto pequeño");
            casilla++;
        }else{
            System.out.println("Resbalón pequeño");
            casilla-=2;
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
        while (casilla < 70 && t.getCasilla()<70) {
            try {
                sleep(100);
                suceso();
                if(casilla>=70){
                    System.out.println("L ganó la carrera");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Tortuga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
