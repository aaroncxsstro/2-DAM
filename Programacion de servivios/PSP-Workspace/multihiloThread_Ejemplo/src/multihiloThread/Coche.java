package multihiloThread;

public class Coche extends Thread{
	private String simbolo;

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Coche(String simbolo) {
		super();
		this.simbolo = simbolo;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(simbolo);
		}
	}
}
