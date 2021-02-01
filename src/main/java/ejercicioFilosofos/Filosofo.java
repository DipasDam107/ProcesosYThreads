/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioFilosofos;

/**
 *
 * @author daniel.ignacio.dipas
 */
public class Filosofo implements Runnable{
    private final Object tenedorIzquierda;
    private final Object tenedorDerecha;
    private int id;

    public Filosofo(Object left, Object right, int id) {
        this.tenedorIzquierda = left;
        this.tenedorDerecha = right;
        this.id=id;
    }

    // La función de meditar simplemente hace pasar un tiempo aleatorio entre 10 milésimas y 20
    private void meditar() throws InterruptedException {
        Thread.sleep(((int) Math.random() * 10) + 10);
    }

    /*El filósofo, medita, "reserva" el tenedor de la izquierda, vuelve a meditar y al reservar el de la derecha come y suelta ambos para volver a empezar el proceso*/
    public void run() {
        try {
            while (true) {
               meditar(); // thinking
                System.out.println("DDP - El filósofo "+this.id+" está meditando");
                System.out.flush();
               
                /**/
                synchronized (tenedorIzquierda) {
                   meditar();
                    
                    synchronized (tenedorDerecha) {
                        meditar(); // eating
                        System.out.println("DDP - El filósofo "+this.id+" esta comiendo");
                        System.out.flush();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

}
