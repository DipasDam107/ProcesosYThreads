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
public class ThreadContador implements Runnable {
    Counter c;
    static int cont;
    
    ThreadContador(Counter c){
        this.asignarConuter(c);
        ThreadContador.cont=0;
    }
    final void asignarConuter(Counter c){
        if (c!=null){
            this.c=c;
        }
    }
    static void incrementarCont(){
        ThreadContador.cont++;
    }
    @Override
    public void run(){
        for (int i = 0; i < 1000000; i++) {
            c.increment();
            ThreadContador.incrementarCont();
        }
        
    }

}
