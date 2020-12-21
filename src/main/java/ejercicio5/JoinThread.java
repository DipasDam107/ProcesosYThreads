/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio5;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class JoinThread implements Runnable{
    public void run() {
    	System.out.println("Di Pasqua - Primer mensaje por consola");
	}
 
	public static void main(String args[]) throws InterruptedException{
    	Thread t= new Thread(new JoinThread());
    	t.start();
    	t.join();
    	System.out.println("Di Pasqua - Segundo mensaje de  por consola");
	}

}
