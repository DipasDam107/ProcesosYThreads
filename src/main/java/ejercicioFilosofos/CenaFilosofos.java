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
public class CenaFilosofos {
    final static int FILOSOFOS_NUMERO = 10;
    
    public static void main(String[] args){

        //Supongamos que tenemos 10 filosofos
        final Filosofo[] filosofos = new Filosofo[FILOSOFOS_NUMERO];
        
        //Cada filósofo tendrá un tenedor a cada lado (Que se puede comer perfectamente con uno, pero supongamos que necesitan 2 para proceder xD). Se declara el array y se inicializa.
        Object[] tenedores = new Object[FILOSOFOS_NUMERO];
     
        for (int i = 0; i < FILOSOFOS_NUMERO; i++) {
            tenedores[i] = new Object();
        }
        //Recorremos los filósofos para ponerles los tenedores a cada lado
        for (int i = 0; i < FILOSOFOS_NUMERO; i++) {
            Object tenedorIzquierda = tenedores[i];
            Object tenedorDerecha;   
            
            /*Cuando el tenedor de la izquierda sea el ultimo, el tenedor de la derecha tiene que ser el de la izquierda del primer filósofo*/
            if(i==(FILOSOFOS_NUMERO-1))
                tenedorDerecha = tenedores[0];
            else 
                tenedorDerecha = tenedores[i + 1];
            
            //Este es el punto crítico de la aplicación. Supongamos que cada Thread (Filósofo) coge el tenedor de la izquierda
            //Como todos los filósofos cogen el tenedor a su izquierda, y necesitan dos para comer, al buscar el de la derecha se encuentra que ya está "reservado" por otro filósofo
            //RESULTADO: Todos mueren de hambre, a filosofar al cementerio
            filosofos[i] = new Filosofo(tenedorIzquierda, tenedorDerecha, i);
            
            
            /*La solución en este caso pasa por hacer que el primer filósofo en vez de buscar el primer tenedor a la izquierda, lo busque a la derecha*/
            /*De esta manera la aplicación se desbloquea, siempre habrá alguien con dos tenedores disponibles para comer, no se produce el deadlock*/
            /*RESULTADO: Hay chapa para rato*/
            /*
                if(i==0)
                    filosofos[i] = new Filosofo(tenedorDerecha, tenedorIzquierda, i);
                else
                    filosofos[i] = new Filosofo(tenedorIzquierda, tenedorDerecha, i);
            */
            
            Thread t = new Thread(filosofos[i]);
            t.start();
        }

    }
}
