/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio12_1;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class DeadLock {
     static class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        //Al estar el método sincronizado, cada uno de los objetos adquiere el monitor del otro, y no se peuden responder el saludo
        public synchronized void bow(Friend bower) {
            System.out.format("DDP - %s: %s"
                    + "  has bowed to me!%n",
                    this.name, bower.getName());
            
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("DDP - %s: %s"
                    + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Friend alphonse
                = new Friend("Alphonse");
        final Friend gaston
                = new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();
        
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }

}
