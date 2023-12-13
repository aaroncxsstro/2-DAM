package Barberia;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Barberia {
	
	private int sillasEspera = 5;
	private int sillon = 1;
	private boolean sillonOcupado = false;
	private Semaphore enEspera = new Semaphore(sillasEspera);
	private Semaphore sentado = new Semaphore(sillon);
	private Semaphore cortandoPelo = new Semaphore(1);

	public void cortarseElPelo(String nombreCliente) {
		try {
			System.out.println(nombreCliente + " intenta sentarse en espera");
			enEspera.acquire();
			System.out.println(nombreCliente + " esta sentado en espera");
			enEspera.release();
			sentado.acquire();
			System.out.println(nombreCliente + " se ha sentado en el sillon");
			sillonOcupado = true;

			while (sillonOcupado) {
				Thread.sleep(1000);
			}
			System.out.println(nombreCliente + " se ha levantado");
			sentado.release();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void atenderCliente(String nombreBarbero) {
		try {
			Random random = new Random();
			if (sillonOcupado) {
				
				boolean cortaPelo = random.nextBoolean();

				if (cortaPelo) {
					cortandoPelo.acquire();
					System.out.println("El barbero está cortando el pelo");
					Thread.sleep(random.nextInt(6000) + 5000);
					System.out.println("El barbero ha terminado de cortar el pelo");
					System.out.println("El barbero va a limpiar el desorden...");
					Thread.sleep(5000);
					System.out.println("El barbero ha terminado. Sillon disponible");
					sillonOcupado = false;
					cortandoPelo.release();
				} else {
					System.out.println("El barbero se hace el loco y continua dormitando");
					Thread.sleep(random.nextInt(4000) + 3000);
				}
			} else {
				System.out.println("El barbero no ha visto ningún cliente y se ha dormido");
				Thread.sleep(random.nextInt(10000) + 10000);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
