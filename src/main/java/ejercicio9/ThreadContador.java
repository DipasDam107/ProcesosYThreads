/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio9;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class ThreadContador implements Runnable{
    Counter c;
    int operacion;
    //1 sumar 0 restar
    ThreadContador(Counter c, int operacion){
        this.asignarCounter(c);
        this.operacion = operacion;
    }
    void asignarCounter(Counter c){
        if (c!=null){
            this.c=c;
        }
    }
    @Override
    public void run(){
        if(operacion == 1)
            for (int i = 0; i < 1000000; i++) {
                c.increment();
            }
        else
            for (int i = 0; i < 1000000; i++) {
                c.decrement();
            }
    }
}
