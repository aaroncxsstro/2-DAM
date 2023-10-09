package hilosNumeros;

import java.util.ArrayList;

public class Numeros extends Thread{

	private String nombre;
	
	public Numeros(String nombre) {
		super();
		this.nombre = nombre;
	}

	static ArrayList<String> numeros = new ArrayList<String>();
	
public static void añadirNumero(String numero) {
		
	numeros.add(numero);
	

	}

	@Override
	public synchronized void run() {
		 int i = 1;
	        while (i) {
	            añadirNumero(nombre + ": " + i);
	            System.out.println(nombre + " agregó: " + i);
	            i++;
	        }
	}
}
