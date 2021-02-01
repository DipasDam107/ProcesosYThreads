
package ejercicioBarbero;

import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;

public class Barberia {
        private ArrayBlockingQueue<Cliente> cola;
	private int tiempoCorte;

	Barberia(int capacidadCola, int tiempoCortePelo) {
		this.cola = new ArrayBlockingQueue<Cliente>(capacidadCola);
		this.tiempoCorte = tiempoCortePelo;
	}

        /*
            Los clientes entran a la cola hasta que es su turno. Si el barbero esta dormido le despiertan
        */
        /* Al llegar el cliente...
                    - Despierta al barbero si esta durmiendo
                    - Si el barbero está ocupado espera en la cola
                
        */
        
	void entrarBarberia() throws InterruptedException {
		Cliente cli = (Cliente) Thread.currentThread();
		LocalDateTime fecha = LocalDateTime.now();
		System.out.println(cli.getNombre() + " llegó a las " + fecha.getHour() + ":" + fecha.getMinute() + ":" + fecha.getSecond() + ".");
		if (cola.remainingCapacity() > 0) {
			cola.offer(cli);
		} else {
			System.out.println("No hay mas sitios en la cola, " + cli.getNombre() + " ha decidido que tenía mejores cosas que hacer.");
		}
                
                
		synchronized (this) {
			notifyAll();
		}
	}
        
        /* Este método es llamado por el barbero. Empieza el trabajo a la espera de que haya clientes en la cola */
	// this method is called by the barber thread, where he serves customers
	// waiting in the queue, if there are none, he falls asleep
	synchronized void trabajar() throws InterruptedException {
		System.out.println("Barbero: 'Al turrón!. Empieza el trabajo.'");

		// this loop is here to ensure, that after all customers are served,
		// the barber can fall asleep and then be woken up again.
		while (true) {
			while (cola.size() == 0) {
				System.out.println("No hay nadie esperando. El barbero se echa una merecida siestecita...");
				wait();
			}
			
			despertarBarbero();
		}
	}

	// Aquí nos aseguramos de que si hay gente en la cola, el barbero no se quede dormido
	private void despertarBarbero() throws InterruptedException {
                //Avisa que el cliente con prioridad al barbero, sin removerlo de la cola
		System.out.println(((Cliente)cola.peek()).getNombre() + " despierta cruelmente al barbero");
		
		while (!cola.isEmpty()) {
			// El barbero llama a un cliente a cortarse el pelo y lo saca de la cola
			cola.poll().sentarseConBarbero();
		}
	}

	// this method is called by a customer that was 'called' by the barber
	synchronized void cortarPelo(Cliente customer) throws InterruptedException {
		String nombre = customer.getNombre();

		System.out.println("El barbero corta el pelo a " + nombre);
		Thread.sleep(tiempoCorte * 10000);
		System.out.println(nombre + " luce un envidiable nuevo peinado");
	}
	
}
