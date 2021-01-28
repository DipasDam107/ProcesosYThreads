
package ejercicio15_1;

public class Cars {
    private int number;
    private static Object primeroMonitor = new Object();
    
	public Cars(int t) {
            number = t;
	}
    
	public int getNumber() {
            return number;
	}
    
	public synchronized void waiting(Cars t) {
            
            System.out.format("DDP7 - Car " + number + " is waiting for Car " + t.getNumber() + "\n");
            t.lane(this);
 
	}
    
	public synchronized void lane(Cars t) {
            System.out.format("DDP7 - Car " + t.getNumber() + " is NOT waiting for " + number  + " anymore\n");
	}

}
