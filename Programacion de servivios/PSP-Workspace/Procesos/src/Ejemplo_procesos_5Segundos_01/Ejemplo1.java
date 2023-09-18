package Ejemplo_procesos_5Segundos_01;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.Date;

public class Ejemplo1 {

	public static void main(String[] args) throws IOException {


		final String RUTA = "notepad.exe";
		
		Process ps = Runtime.getRuntime().exec(RUTA);
		

		
		try {
			while(ps.waitFor(5, TimeUnit.SECONDS)==false){
				 Date date = new Date();
				 System.out.println(date + " El proceso notepad.exe sigue activo");
			}
	
			System.out.println("El proceso ha terminado");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Mal");
			e.printStackTrace();
		}

	}

}
