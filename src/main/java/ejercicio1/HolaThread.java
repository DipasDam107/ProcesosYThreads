/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class HolaThread extends Thread{
    public void run() {
    	System.out.println("Hola desde un thread con herencia" + " - Daniel Di Pasqua");
	}
 
	public static void main(String args[]) {
    	(new HolaThread()).start();
    }

}
