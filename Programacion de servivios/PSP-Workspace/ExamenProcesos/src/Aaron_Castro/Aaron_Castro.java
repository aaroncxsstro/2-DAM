package Aaron_Castro;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.File;


public class Aaron_Castro {

	public static void main(String[] args) throws IOException {
		
	            String direccion = "www.google.com";
	            ProcessBuilder cmd = new ProcessBuilder("ping", direccion);
	            
	            File file = new File("archivo.txt");
	          // File file = new File (args[0]);
	           

	 		   cmd.redirectInput(file);
	            
	 			try {
	 				Process p = cmd.start(); 
	 				
	 				BufferedReader reader = new BufferedReader (new InputStreamReader(p.getInputStream()));
		 			
	 				int contador=0;
		 			String linea;
		 			
		 			while ((linea = reader.readLine())!=null) {
		 				if(contador==1) {
		 				System.out.println(linea);
		 				}
		 				contador++;
		 			}
	 				
	 			} catch (IOException e) {
	 				System.out.println("No ha podido iniciarse el proceso");
	 				e.printStackTrace();
	 				
	 			}
	 		  
	 			
	 			final String PAD = "mspaint.exe";

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


