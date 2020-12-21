/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class HolaRunnable implements Runnable {
   public void run() {
        System.out.println("Hola desde un thread con Runnable" + " - Daniel Di Pasqua");
    }
 
    public static void main(String args[]) {
    (   new Thread(new HolaRunnable())).start();
    }
 
}
