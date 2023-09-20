package EjemploRedirect;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.io.File;
public class EjemploRedirect {

	public static void main(String[] args) {
		
		ProcessBuilder cmd = new ProcessBuilder("cmd","/c","dir");
		
		//salida.txt
		
		File file = new File ("Salida.txt");
		   cmd.redirectOutput(file);
		   cmd.redirectInput(file);
		   File file2 = new File ("Salida2.txt");
		   cmd.redirectOutput(file2);
	
		try {
			Process p = cmd.start();
			
		} catch (IOException e) {
			System.out.println("No ha podido iniciarse el proceso");
			e.printStackTrace();
		}
	
	
		


	}

}
