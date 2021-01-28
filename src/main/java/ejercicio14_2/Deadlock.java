
package ejercicio14_2;

import ejercicio14_1.*;

/**
Resolver el deadlock.
Sólo deberá modificarse uno de los threads.
No se podrá modificar el orden en el que acceden a los recursos
 */
public class Deadlock {
     public static void main(String[] args) {
    final Object resource1 = "resource1";
    final Object resource2 = "resource2";
    
    Thread t1 = new Thread() {
      public void run() {
        
        synchronized(resource1) {
          
          System.out.println("DDP Thread 1: locked resource 1");

          try { Thread.sleep(50); } catch (InterruptedException e) {}
          }  

        
          synchronized(resource2) {
            System.out.println("DDP Thread 1: locked resource 2");
          }
        
      }
    };
    
    Thread t2 = new Thread() {
      public void run() {
        synchronized(resource2) {
          System.out.println("DDP Thread 2: locked resource 2");

          try { Thread.sleep(50); } catch (InterruptedException e) {}

          synchronized(resource1) {
            System.out.println("DDP Thread 2: locked resource 1");
          }
        }
      }
    };
    
    t1.start(); 
    t2.start();
  }

}
