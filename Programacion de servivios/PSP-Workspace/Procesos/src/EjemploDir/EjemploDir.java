package EjemploDir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjemploDir {

	public static void main(String[] args) {
		
		try {
			Process ps = Runtime.getRuntime().exec("cmd /c dir");
			System.out.println("Id del proceso "+ ps.pid());
			
			BufferedReader reader = new BufferedReader (new InputStreamReader(ps.getInputStream()));
			
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			
			ps.destroy();
			System.out.println("Proceso finalizado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
