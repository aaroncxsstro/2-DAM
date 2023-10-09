package Pistola;

public class Main {

	public static void main(String[] args) {

		Pistola p1 = new Pistola ();
		
		new Thread() {
			@Override
			public void run() {
				p1.disparar(60);
			}
		}.start();
		
		new Thread ( ) {
			@Override
			public void run() {
				p1.recargar();
			}
		}.start();

	}

}
