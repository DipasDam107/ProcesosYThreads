/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio10_1;

import ejercicio10_2.*;
import ejercicio10_3.*;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class ThreadContador implements Runnable{
    Counter c;
    //1 sumar 0 restar
    ThreadContador(Counter c ){
        this.asignarCounter(c);
    }
    void asignarCounter(Counter c){
        if (c!=null){
            this.c=c;
        }
    }
    @Override
    public void run(){
       
            for (int i = 0; i < 1000000; i++) {
                c.increment();
            }
    }
}
