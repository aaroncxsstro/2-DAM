package ejemplo_sincronizacion;

public class Counter {

	private boolean sincronizado;

	public Counter(boolean sincronizado) {
		super();
		this.sincronizado = sincronizado;
	}
	
	public boolean isSincronizado() {
		return sincronizado;
	}
	
	public synchronized void mostrarNumerosSincronizados(int id, int n) {
		System.out.println("Inicio del hilo");
		
		for(int i = 0; i<=n; i++) {
			System.out.println(i);
		}
		System.out.println("Fin de hilo");
	}
	
	public void mostrarNumerosNoSincronizados(int id, int n) {
		System.out.println("Inicio del hilo");
		
		for(int i = 0; i<=n; i++) {
			System.out.println(i);
		}
		System.out.println("Fin de hilo");
	}
}
