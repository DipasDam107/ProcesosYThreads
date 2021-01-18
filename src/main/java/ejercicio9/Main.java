/*
 Interleaving entre threads
Los threads actuan sobre variables compartidas
Observo como cada ejecución da distintos resultados, diferentes al esperado
Ya que se pisan entre ellos
 */
package ejercicio9;

public class Main {
    public static void main(String [] args) throws InterruptedException{
        Thread t1, t2, t3, t4;
        Counter suma=new Counter();
        Counter resta=new Counter();
        
        //Implemento un nuevo parámetro en el constructor, que indica la operación (1-suma, 0-resta)
        t1=new Thread(new ThreadContador(suma,1));
        t2=new Thread(new ThreadContador(suma,1));        
        t3=new Thread(new ThreadContador(resta,0));        
        t4=new Thread(new ThreadContador(resta,0));        
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        
        System.out.println("DDP7 Contador final Suma: "+ suma.value() + "\n" + "DDP7 Contador final resta: "+ resta.value());
    }
}
