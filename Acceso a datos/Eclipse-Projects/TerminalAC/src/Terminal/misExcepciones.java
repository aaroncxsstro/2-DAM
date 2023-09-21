package Terminal;

public class misExcepciones extends Exception {
	
    public misExcepciones() {
        super("Esta es una excepción personalizada");
    }

    public misExcepciones(String mensaje) {
        super(mensaje);
    }
}