package Terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	static String ruta;
	public static void main(String[] args) {
		
		ruta = System.getProperty("user.dir");
		generarMenu(ruta);

	}
	
	public static void generarMenu(String ruta) {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("\r\n"+ruta+">");
		String comando = tec.nextLine();
		String[] partido = comando.split(" ");
		
		switch (partido[0].toLowerCase()) {
		case "help": 
			System.out.println("help -> lista todos comandos\".\r\n"
					+ "cd -> muestra la ruta del directorio actual\r\n"
					+ "cd .. -> Se mueve al directorio padre.\r\n"
					+ "cd + nombre -> lista archivos de ese directorio.\r\n"
					+ "mkdir -> crea un directorio de la ruta actual\r\n"
					+ "info <nombre> -> Muestra la información del elemento Indicando\r\n"
					+ "cat <nombreFichero> -> Muestra el contenido de un fichero.\r\n"
					+ "top <numeroLineas><NombreFichero> -> Muestra las líneas especificadas de un fichero.\r\n"
					+ "mkfile <nombreFichero> <texto> ->  Crea un fichero con ese nombre y el contenido de texto.\r\n"
					+ "write <nombreFichero> <texto>-> Añade 'texto' al final del fichero especificado.\r\n"
					+ "dir -> Lista los archivos o directorios de la ruta actual.\r\n"
					+ "readpoint <nombreFichero1> <posición> -> Lee un archivo desde una determinada posición del puntero.\r\n"
					+ "delete <nombre> -> Borra el fichero, si es un directorio borra todo su contenido y a si mismo.\r\n"
					+ "Start <programa> - >ejecuta este proceso.\r\n"
					+ "close -> Cierra el programa.\r\n"
					+ "Clear -> Vacía la lista.");
			generarMenu(ruta);
			break;
		case "cd":
			if (partido.length==1) {
				System.out.println(ruta);
				generarMenu(ruta);
			}else if(partido[1].equalsIgnoreCase("..") && partido.length==2){
				String[] rutapartida = ruta.split("\\\\");
				String rutatemp="C:";
				for(int i=1; i<rutapartida.length-1; i++) {
					rutatemp=rutatemp+"\\"+rutapartida[i];
				}
				ruta=rutatemp;
				generarMenu(ruta);
			}else if (partido.length==2){{
				
				Path path = Path.of(ruta+"\\"+partido[1]);
				
					try {
						Stream<Path> stream = Files.list(path);
						ArrayList<Path> lista = (ArrayList <Path>)stream.collect(Collectors.toList());
						for (Path item : lista) {
							System.out.println(item);
						}
					}catch (NoSuchFileException e) {
					    System.err.println("El directorio especificado no existe: " + path.toString());
					    generarMenu(ruta);
					    
					} catch (IOException e) {
						generarMenu(ruta);
						e.printStackTrace();
					}
					generarMenu(ruta);
					}
			}
				
				
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
			
			default: 
				System.out.println("Comando no valido (usa help para ver los comandos)");
				generarMenu(ruta);
				break;
		}
	}

}
