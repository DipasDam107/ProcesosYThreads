/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13_2;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class Transferencia implements Runnable {

    Cuenta c1, c2;

    Transferencia(Cuenta c1, Cuenta c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            c1.transfer(c1,c2,1);
        }
    }

    
}
