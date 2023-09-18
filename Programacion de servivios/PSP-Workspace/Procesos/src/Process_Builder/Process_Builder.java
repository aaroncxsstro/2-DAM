package Process_Builder;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Process_Builder {

	public static void main(String[] args) throws IOException {

		//1. Instanciar el lanzador de procesos
		//2. Construir el comando a jecutar
		//3. Lanzar el comando
		//4. Obtener el id
		//5. Destruir el proceso
		final String PAD = "notepad.exe";

		ProcessBuilder pb = new ProcessBuilder(PAD);
		
	
			Process ps = pb.start();
	
		
		System.out.println("ID del proceso :" + ps.pid());
		
		// Capturar la salida
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(ps.getInputStream()));
		
		String linea;
		
		while ((linea = reader.readLine())!=null) {
			System.out.println(linea);
		}
		
		ps.destroy();
		System.out.println("Proceso finalizado");
		}

}
