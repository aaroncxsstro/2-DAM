package multihiloRunnable;

public class Coche implements Runnable{
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
		// TODO Auto-generated method stub
		
	}
	
}