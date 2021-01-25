
package ejercicio11_1;


public class Main {
    public static void main(String [] args) throws InterruptedException{
         Thread t1, t2;
        Counter c=new Counter();
        ThreadContador tc1, tc2;
        tc1=new ThreadContador(c);
        tc2=new ThreadContador(c);
        t1=new Thread(tc1);
        t2=new Thread(tc2);        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("DDP7 Contador final de Counter: "+c.value());
        System.out.println("DDP7 Contador final del thread 1: "+tc1.cont);
        System.out.println("DDP7 Contador final del thread 2: "+tc2.cont);
    }
}
