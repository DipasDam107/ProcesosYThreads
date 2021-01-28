/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio13_3;

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

    void transfer(Cuenta from, Cuenta to, double amount) {
        Cuenta primero, segundo;
        
        if(from.id < to.id){
            primero = from;
            segundo = to;
        }
        else{
            primero = to;
            segundo = from;
        }
        synchronized(primero){
            synchronized(segundo){
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
        
    }

}
