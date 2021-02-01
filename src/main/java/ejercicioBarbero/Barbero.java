
package ejercicioBarbero;

public class Barbero extends Thread{
        Barberia barberia;

	Barbero(Barberia barberia) {
		this.barberia = barberia;
	}

	@Override
	public void run() {
            try {
                    barberia.trabajar();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
            super.run();
	}
}
