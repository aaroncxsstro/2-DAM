package multihiloThread;

public class Main {

	public static void main(String[] args) {

		Coche c1 = new Coche ("1");
		Coche c2 = new Coche ("2");
		Coche c3 = new Coche ("3");
		Coche c4 = new Coche ("4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}

}
