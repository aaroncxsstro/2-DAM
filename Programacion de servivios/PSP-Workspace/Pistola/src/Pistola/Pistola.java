package Pistola;

public class Pistola {

	private int balas = 40;

	public int getBalas() {
		return balas;
	}

	public void setBalas(int balas) {
		this.balas = balas;
	}
	
	public synchronized void disparar(int balasADisparar) {
		
		for(int i = 1; i<balasADisparar; i++) {
			System.out.println("Bala "+ i + "disparada");
			
			if(balas == 0) {
				System.out.println(i - 1 + "balas disparadas "+ balas + " restantes");
				System.out.println("Invocando al método wait...");
				
				try {
					wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				
				System.out.println("Continuando el fuego después de recargar");
			}
			balas --;
		}
		
		System.out.println("Tiroteo finalizado");
	}
	
	public synchronized void recargar() {
		
		System.out.println("Pistola recargada con otras 40 balas");
		
		balas = balas + 40; //balas +=40;
		notify();
	}
}
