package Ejemplo_procesos_argumentos_02;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Argumentos {


	public static void main(String[] args) throws IOException, InterruptedException {


		final String RUTA = args[0];
		
		
		
		if(args.length<2) {
			System.out.println("Los argumentos deben ser al menos dos");
			}else {
			   for (int i=0; i<Integer.valueOf(args[1]); i++) {
				   Process ps = Runtime.getRuntime().exec(RUTA);
			   }
			}
	

	}


}
