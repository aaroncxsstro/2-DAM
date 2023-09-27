package ejemplo_sincronizacion;

public class Main {

	public static void main(String[] args) {

		boolean sincronizado = false;
		
		Counter c = new Counter (sincronizado);
		HiloContador h1 = new HiloContador (1,c,10);

	}

}
