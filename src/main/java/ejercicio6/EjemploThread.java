/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class EjemploThread {
    static void mensajeThread(String mensaje) {
        String nombreThread = Thread.currentThread().getName();
        System.out.format("Di Pasqua - %s:%s%n", nombreThread, mensaje);
    }

    private static class BucleMensaje implements Runnable {

        public void run() {
            String informacion[] = {
                "No temo a los ordenadores; lo que temo es quedarme sin ellos -- Isaac Asimov",
                "El software es un gas: se expande hasta llenar su contenedor -- Nathan Myhrvold",
                "La física es el sistema operativo del Universo -- Steven R Garman",
                "Tus clientes más descontentos son tu mayor fuente de aprendizaje -- Bill Gates"
            };

            for (int i = 0; i < informacion.length; i++) {
                try {
                    Thread.sleep(4000);
                    mensajeThread(informacion[i]);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrumpido por Di Pasqua en el mensaje " + i);
                    //Salir del for
                    break;
                }
            }
        }
    }
        public static void main(String args[]) throws InterruptedException {
        long paciencia = 1000 * 10;
        mensajeThread("Iniciando el thread 'BucleMensaje'");
        long tiempoDeInicio = System.currentTimeMillis();
        Thread t = new Thread(new BucleMensaje());
        t.start();
        mensajeThread("Esperando a que termine el thread 'BucleMensaje'");
        while (t.isAlive()) {
            mensajeThread("Esperando todavía...");
            t.join(1000);
            if (((System.currentTimeMillis() - tiempoDeInicio) > paciencia) && t.isAlive()) {
                mensajeThread("Paciencia agotada. Deteniendo thread.");
                t.interrupt();
            }
        }
    }

    
}
