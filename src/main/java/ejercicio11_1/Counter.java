/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio11_1;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class Counter {
    
    private int c;

    Counter(){
        this.c=0;
    }
    public void increment() {
        synchronized(this){
            c++;
        }
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

  }

