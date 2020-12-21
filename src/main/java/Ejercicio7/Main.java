
package Ejercicio7;

import java.util.Scanner;

public class Main {
     static Scanner teclado;
     static Thread mensajeThread;
     static Thread interrumpirThread;
     static Thread duranteReinicio;
     
     public static void main(String args[]) throws InterruptedException {
       teclado = new Scanner(System.in);
       
       mensajeThread = new Thread(new RebootMsg());
       interrumpirThread = new Thread(new RebootInterruption());
       duranteReinicio = new Thread(new DuringReboot());
      
       mensajeThread.start();
       interrumpirThread.start();
       duranteReinicio.start();
     }
     
     private static class RebootMsg implements Runnable {
        public void run(){
            try{
            for (int i = 5; i > 0; i--) {
              System.out.println("DDP - Your computer will reboot in " + i + " seconds. Press enter to reboot.");
              Thread.sleep(1000);  
            }
                System.out.println("DDP - Normal reboot.");
            }catch(InterruptedException e){
                System.out.println("DDP - Rebooting right away!");
            }finally{
                System.exit(0);
            }        
        }
     }
     private static class RebootInterruption implements Runnable {
        public void run() {
            teclado.nextLine();
            mensajeThread.interrupt();
        }
     }
     
     private static class DuringReboot implements Runnable {
        public void run() {
            try{
                mensajeThread.join(3000);
                if(mensajeThread.isAlive())
                    System.out.println("DDP - About to reboot...");
            }catch(InterruptedException e){
                e.printStackTrace();
                
            }
            }
     }
     
     
}
