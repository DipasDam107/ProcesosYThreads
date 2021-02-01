
package ejercicioBarbero;

public class Main {
    
    private static final int CAPACIDAD_COLA = 2;
    private static final int TIEMPO_CORTE = 10;
    private static final int TIEMPO_ENTRE_CLIENTES = 10000;

    public static void main(String[] args) throws InterruptedException {
        /*Nombres de los clientes que luego se cogen aleatoriamente*/
        String[] Nombres = {
                "Dani", "Juan", "Maria", "Pepe", "Doval", "Xian", "Raul", "Marta", "Sara", "Brais", "Florentino Perez"
        };

        // Inicializo la barberia con el tiempo de cada corte de pelo aproximado y la capacidad de la cola
        Barberia barberia = new Barberia(CAPACIDAD_COLA, TIEMPO_CORTE);

        // Incicializo al barbero
        Barbero barber = new Barbero(barberia);
        barber.start();

       
        Cliente cliente;
        
        //El proceso dura indefinidamente, cada cierto tiempo aleatorio se genera un nuevo cliente con un nombre y empieza su thread.
        while(true){
            long tiempoEntreClientes = Math.round(Math.random() * TIEMPO_ENTRE_CLIENTES);
        
            try {
                Thread.sleep(tiempoEntreClientes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            cliente = new Cliente(barberia);
            int randomNameIndex = (int) Math.round(Math.random() * 10);
            
            cliente.setNombre(Nombres[randomNameIndex]);
            cliente.start();
        }
    } 
}
