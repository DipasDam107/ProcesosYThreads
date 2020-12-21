
package ejercicio3;

public class DormirMensajes {
    public static void main(String args[]) throws InterruptedException {
    	String informacion[] = {
        	"No temo a los ordenadores; lo que temo es quedarme sin ellos -- Isaac Asimov",
        	"El software es un gas: se expande hasta llenar su contenedor -- Nathan Myhrvold",
        	"La física es el sistema operativo del Universo -- Steven R Garman",
        	"Tus clientes más descontentos son tu mayor fuente de aprendizaje -- Bill Gates"
        };
 
    	for (int i = 0;
         	i < informacion.length;
         	i++) {
        	//Pausa 4 segundos
            Thread.sleep(2000);
        	System.out.println("Di Pasqua Frase " + (i+1) + " | " + informacion[i]);
    	}
    }

}
