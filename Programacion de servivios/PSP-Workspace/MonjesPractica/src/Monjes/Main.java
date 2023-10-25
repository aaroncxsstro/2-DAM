package Monjes;

public class Main {
	
public static void main(String[] args) {
 int numMonjes =5;    	

 Mesa mesa = new Mesa(numMonjes);
 for (int i = 1; i <= 5; i++) {
	 Monje m1 = new Monje(mesa, i);
	 m1.start();
	        }
	    }
	}