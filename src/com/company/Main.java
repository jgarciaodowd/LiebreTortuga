package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Liebre l=new Liebre();
        Tortuga t=new Tortuga();
        l.setTortuga(t);
        t.setLiebre(l);
        l.start();
        t.start();

    }
}
