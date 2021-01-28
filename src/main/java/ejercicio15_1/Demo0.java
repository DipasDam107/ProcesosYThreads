/*
Todos los coches se esperan, se produce deadlock
 */
package ejercicio15_1;

public class Demo0 {
    public static void main(String[] args) {
    	Cars demo1 = new Cars(1);
    	Cars demo2 = new Cars(2);
    	Cars demo3 = new Cars(3);
    	Cars demo4 = new Cars(4);
   	 
    	new Thread(new Runnable() {
        	@Override
        	public void run() {
            	demo1.waiting(demo2);
        	}
    	}).start();
   	 
    	new Thread(new Runnable() {
        	@Override
        	public void run() {
            	demo2.waiting(demo3);
        	}
    	}).start();
   	 
    	new Thread(new Runnable() {
        	@Override
        	public void run() {
            	demo3.waiting(demo4);
        	}
    	}).start();
   	 
    	new Thread(new Runnable() {
        	@Override
        	public void run() {
            	demo4.waiting(demo1);
        	}
    	}).start();
	}

}
