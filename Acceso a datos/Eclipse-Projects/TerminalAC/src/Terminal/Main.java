package Terminal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		generarMenu();
//String ruta = System.getProperty("user.dir"); Almacena la ruta
	}
	
	public static void generarMenu() {
		Scanner tec = new Scanner(System.in);
		String ruta = System.getProperty("user.dir");
		System.out.println(ruta+">");
		String comando = tec.next();
		String[] partido = comando.split(" ");
		
		
		switch (partido[0]) {
		case "help": 
			
			break;
		case "cd":
		
			break;
		case "mkdir":
			
			break;
		case "info":
			
			break;
		case "cat":
			
			break;
		case "top":
			
			break;
			
		case "mkfile":
			
			break;
		case "write":
			
			break;
			
		case "dir":
			
			break;
		case "readpoint":
			
			break;
		case "delete":
			
			break;
		case "start":
			
			break;
		case "close":
			
			break;
			
		case "clear":
			
			break;
		}
	}

}
