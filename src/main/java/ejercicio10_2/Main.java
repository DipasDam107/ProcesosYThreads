/*
 Interleaving entre threads
si usamos la palabra reservada synchronized, no se ejecutaran paralelamente
si no que java se asegura que dicho metodo solo se este ejecutando una vez al mismo tiempo
 */
package ejercicio10_2;

import ejercicio10_3.*;

public class Main {
    public static void main(String [] args) throws InterruptedException{
        long start = System.currentTimeMillis();
        Thread t1, t2, t3, t4;
        Counter c=new Counter();
        
        
        //Implemento un nuevo parámetro en el constructor, que indica la operación (1-suma, 0-resta)
        t1=new Thread(new ThreadContador(c,1));
        t2=new Thread(new ThreadContador(c,1));        
        t3=new Thread(new ThreadContador(c,0));        
        t4=new Thread(new ThreadContador(c,0));        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        System.out.println("DDP7 Contador final: "+ c.value() );
        long end = System.currentTimeMillis();
        System.out.println("DDP7 Time end: " + (end - start));
    }
}
