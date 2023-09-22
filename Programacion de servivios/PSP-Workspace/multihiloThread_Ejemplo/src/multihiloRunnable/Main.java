package multihiloRunnable;

public class Main {

	public static void main(String[] args) {
		
		Coche c1 = new Coche ("1");
		Coche c2 = new Coche ("2");
		Coche c3 = new Coche ("3");
		Coche c4 = new Coche ("4");
		/*
		System.out.println("He instanciado 4 coches");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Voy a esperar 3 segundos");
		
		System.out.println("Vuelvo a ejecutar el programa");
		
		*/
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(c3);
		Thread t4 = new Thread(c4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
