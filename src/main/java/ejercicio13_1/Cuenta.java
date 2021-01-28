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
public class Cuenta {
     double balance;
    int id;

    Cuenta(int id, double balance) {
        this.id = id;
        this.balance=balance;
    }

    private void withdraw(double amount) {
        balance -= amount;
    }

    private void deposit(double amount) {
        balance += amount;
    }

    synchronized void transfer(Cuenta from, Cuenta to, double amount) {
        //Al no haber ningun tipo de sincronización, se producen problemas en los calculos
        
                from.withdraw(amount);
                to.deposit(amount);
          
    }
}
