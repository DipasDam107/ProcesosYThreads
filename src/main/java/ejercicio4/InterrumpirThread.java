/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class InterrumpirThread implements Runnable {
     public void run() {
        String informacion[] = {
            "No temo a los ordenadores; lo que temo es quedarme sin ellos -- Isaac Asimov",
            "El software es un gas: se expande hasta llenar su contenedor -- Nathan Myhrvold",
            "La física es el sistema operativo del Universo -- Steven R Garman",
            "Tus clientes más descontentos son tu mayor fuente de aprendizaje -- Bill Gates"
        };

        for (int i = 0;
                i < informacion.length;
                i++) {
            try {
                Thread.sleep(2000);
                System.out.println("Di Pasqua Frase " + (i+1) + " | " + informacion[i]);
            } catch (InterruptedException e) {
                System.out.println("Di Pasqua ha interrumpido el Thread en el mensaje " + i);
                //Salir del for
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new InterrumpirThread());
        t.start();
        Thread.sleep(8000);
        t.interrupt();
    }

}
