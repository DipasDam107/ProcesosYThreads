
package ejercicio11_4;

//4.3.1

import ejercicio11_3.*;
import ejercicio11_2.*;
//4.3.1
public class Main {
    public static void main(String [] args){
      Medicion m = new Medicion();
        Thread t1, t2;
        t1 = new Thread(new Runnable() {
            public void run() {
                m.proceso();
            }
        });
        t2 = new Thread(new Runnable() {
            public void run() {
                m.proceso();
            }
        });
        System.out.println("DDP Starting...");
        // Mediciones de tiempo
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        //Imprimir valores
        System.out.println("DDP Time end: " + (end - start));
        System.out.println("DDP List of temperatures: " + m.numElemList('c'));
        System.out.println("DDP List of Wind Chill temperature : " + m.numElemList('v'));
        
        double[] resultado = m.media();
        
        System.out.println("DDP Average Temperature: " + resultado[0]);
        System.out.println("DDP Average Wind Chill Temperature: " + resultado[1]);
    }

}

