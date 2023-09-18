package Runtime_process;

import java.io.IOException;

public class Runtime_process {

	public static void main(String[] args) throws IOException {


		final String RUTA = "notepad.exe";
		
		Process ps = Runtime.getRuntime().exec(RUTA);
		System.out.println();
		

	}

}
