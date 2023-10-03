package EjemploRedirect;

import java.io.File;
import java.io.IOException;

public class EjemploRedirectContrario {

	public static void main(String[] args) {
		
		ProcessBuilder cmd = new ProcessBuilder("cmd","/c","dir");
		
		//salida.txt
		
		File file = new File ("Salida.txt");
		   cmd.redirectInput(file);
	
		try {
			Process p = cmd.start();
			
		} catch (IOException e) {
			System.out.println("No ha podido iniciarse el proceso");
			e.printStackTrace();
		}
	
		
	}

}
