
package ejercicio15_2;

import ejercicio15_1.*;

public class Cars {
    private int number;
    private static Object primeroMonitor = new Object();
    
	public Cars(int t) {
            number = t;
	}
    
	public int getNumber() {
            return number;
	}
    
	public void waiting(Cars t) {
            
            /*
            Otra solución sería que esperaran todos menos el primero, de esta manera el primero cruza y no bloquea al resto
            
            if(this.number != 1 )
                    try{
                        Thread.sleep(50);
                    }catch(InterruptedException e){

                    }
            synchronized(this){
               System.out.format("DDP7 - Car " + number + " is waiting for Car " + t.getNumber() + "\n");
               t.lane(this);
            }
            */
            
            //Esta solución usa un monitor distinto para el primero
            if(this.number == 1 )
                 synchronized(primeroMonitor){
                    System.out.format("DDP7 - Car " + number + " is waiting for Car " + t.getNumber() + "\n");
                    t.lane(this);
                }
            else
                synchronized(this){
                    System.out.format("DDP7 - Car " + number + " is waiting for Car " + t.getNumber() + "\n");
                    t.lane(this);
                }
            
            
	}
    
	public synchronized void lane(Cars t) {
            System.out.format("DDP7 - Car " + t.getNumber() + " is NOT waiting for " + number  + " anymore\n");
	}

}
