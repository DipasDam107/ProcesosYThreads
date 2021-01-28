/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13_1;

import ejercicio13_2.*;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class UsarCuenta {
     public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final Cuenta c1, c2;
        Thread t1, t2;

        c1 = new Cuenta(1, 1);
        c2 = new Cuenta(2, 1);

        t1 = new Thread(new Transferencia(c1, c2));
        t2 = new Thread(new Transferencia(c2, c1));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.format("DDP El saldo de c1 es: %f\n", c1.balance);
        System.out.format("DDP El saldo de c2 es: %f\n", c2.balance);
        System.out.format("DDP La diferencia de saldo es: %f\n", c1.balance - c2.balance);       
        long end = System.currentTimeMillis();
        System.out.println("DDP Tiempo total: " + (end - start));
     }

}
