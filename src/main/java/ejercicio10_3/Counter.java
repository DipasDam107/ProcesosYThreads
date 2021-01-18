/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10_3;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class Counter {
     private int c;

    Counter(){
        this.c=0;
    }
    
    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}
