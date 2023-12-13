package Barberia;

public class Barbero extends Thread{
	
	private String nombre;
	
    private Barberia barberia;
    
    public Barbero(String nombre, Barberia barberia) {
		this.nombre = nombre;
		this.barberia=barberia;
	}


	@Override
    public void run() {
        while(true){
        	barberia.atenderCliente(nombre);
        }
    }
}
