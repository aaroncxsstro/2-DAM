package ejemplo_sincronizacion;

public class HiloContador extends Thread{

	private int id;
	
	private Counter counter;
	
	private int n;

	public HiloContador(int id, Counter counter, int n) {
		super();
		this.id = id;
		this.counter = counter;
		this.n = n;
	}
	
	public void run() {
		
		if(this.counter.isSincronizado()) {
			this.counter.mostrarNumerosSincronizados(this.id, this.n);
		}else {
			this.counter.mostrarNumerosNoSincronizados(this.id, this.n);
		}
	}
	
}
