
package ejercicioBarbero;

public class Cliente extends Thread{
    Barberia barberia;
    private String nombre;

   
	
	Cliente(Barberia barberShop) {
		this.barberia = barberShop;
	}
	
	@Override
	public void run() {
		try {
                        /*El cliente entra en la barberia*/
			Thread.sleep(Math.round((Math.random() * 1000)));
			barberia.entrarBarberia();
                        
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
	}
	
	// Este método se asegura que el procedimiento sigue su curso después de despertar al barbero
	void sentarseConBarbero() throws InterruptedException {
		barberia.cortarPelo(this);
	}
        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
       
}
