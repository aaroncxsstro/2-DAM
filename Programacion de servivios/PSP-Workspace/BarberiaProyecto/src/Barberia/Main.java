package Barberia;

public class Main {

	public static void main(String[] args) {
        final int BARBERO = 1;
        final int CLIENTE = 7;

        Barberia barberia = new Barberia();
        
        for (int i = 0; i < BARBERO; i++) {
            new Barbero("Barbero " + i, barberia).start();
        }
        
        for (int i = 0; i < CLIENTE; i++) {
            new Cliente("Cliente " + i, barberia).start();
        }

	}

}
