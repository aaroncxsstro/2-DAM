package Barberia;

public class Cliente extends Thread{
	
	private String nombre;
	
	private Barberia barberia;
	
	public Cliente(String nombre, Barberia barberia) {
		this.nombre = nombre;
		this.barberia = barberia;
	}

	@Override
    public void run() {
        while(true){
        	barberia.cortarseElPelo(nombre);
        }
    }
}
