package Terminal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.io.RandomAccessFile;

public class Main {

	static String ruta;
	public static void main(String[] args) {
		
		ruta = System.getProperty("user.dir");
		try {
			generarMenu(ruta);
		} catch (misExcepciones e) {
			e.printStackTrace();
		}

	}
	
	public static void generarMenu(String ruta) throws misExcepciones {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("\r\n"+ruta+">");
		String comando = tec.nextLine();
		String[] partido = comando.split(" ");
		
		switch (partido[0].toLowerCase()) {
		case "help": 
			
			if(partido.length!=1) {
			System.err.println("Numero de parametros no valido");	
			}else {
			System.out.println("help -> lista todos comandos\".\r\n"
					+ "cd -> muestra la ruta del directorio actual\r\n"
					+ "cd .. -> Se mueve al directorio padre.\r\n"
					+ "cd + nombre -> Entrar en el.\r\n"
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
			
			}
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
			}else if (partido.length>=2){{
				
				String rutanueva = (ruta+"\\");
				rutanueva=rutanueva + partido[1];
				
				for(int i = 2; i<partido.length; i++) {
					rutanueva=rutanueva+" "+partido[i];
				}
				 File directorio = new File(rutanueva);
			        if (directorio.exists()) {
				ruta=rutanueva;
			        }else {
			        	System.err.println("La carpeta no existe");
			        }
				generarMenu(ruta);
			}
				
				/*
				*/
				
			}
				generarMenu(ruta);
				
			break;
			
		case "mkdir":
			Path path = Path.of(ruta);
			if(partido.length==1) {
				System.err.println("Debes introducir el nombre de la carpeta");
			}
			
			for (int i=1; i<partido.length; i++) {
				String rutaNueva=ruta+"\\"+partido[i];
		        File directorio = new File(rutaNueva);
		        if (!directorio.exists()) {
		            if (directorio.mkdirs()) {
		                System.out.println("Directorio creado");
		            } else {
		                System.out.println("Error al crear directorio");
		            }
		        }else {
		        	System.err.println("Error al crear el directorio: Ya existe");
		        }
			}
			
			generarMenu(ruta);

			
			
			break;
		case "info":
			
			if (partido.length!=2) {
				System.err.println("Numero de argumentos no válido");
				generarMenu(ruta);
			} else {
		        File archivo = new File(ruta+"//"+partido[partido.length-1]);
		        if (archivo.exists()) {
		            System.out.println("Nombre de Archivo: " + archivo.getName());
		            System.out.println("Absolute path: " + archivo.getAbsolutePath());
		            System.out.println("Permisos de escritura: " + archivo.canWrite());
		            System.out.println("Permisos de lectura: " + archivo.canRead());
		            System.out.println("Tamaño del archivo: " + archivo.length());
		            System.out.println("Carpeta contenedora: " + archivo.getParent());
		            System.out.println("Es archivo: " + archivo.isFile());
		            System.out.println("Es directorio " + archivo.isDirectory());
		            System.out.println("Es oculto: " + archivo.isHidden());
		        } else {
		            System.out.println("El archivo no existe.");
		        }	
		        generarMenu(ruta);
			}
			
			break;
			
		case "cat":
			if(partido.length!=2) {
				System.err.println("Numero de argumentos no valido ");
			}else {
			String rutaNueva=ruta+"\\"+partido[1];
			File fichero = new File (rutaNueva);
			
		    try (BufferedReader br = new BufferedReader(new FileReader(rutaNueva))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                System.out.println(linea); // Muestra cada línea en la consola
	            }
	        } catch (IOException e) {
	            System.out.println("El archivo no existe");
	            generarMenu(ruta);
	        }
			
			}
			 generarMenu(ruta);
			
			break;
		case "top":
			
			if(partido.length!=3) {
				System.err.println("Numero de argumentos no valido ");
			}else {
			String rutaNueva=ruta+"\\"+partido[2];
			File fichero = new File (rutaNueva);
	        try {
	            int numero = Integer.parseInt(partido[1]);
	    	    int numeroLineaDeseada = numero;
		        try (BufferedReader br = new BufferedReader(new FileReader(rutaNueva))) {
		            int numeroLinea = 1;
		            String linea;
		            while ((linea = br.readLine()) != null) {
		                if (numeroLinea == numeroLineaDeseada) {
		                    System.out.println(linea);
		                    break; 
		                }
		                numeroLinea++;
		            }
	        } catch (NumberFormatException e) {
	            System.err.println("La cadena no es un número válido.");
	        }


		               
		        } catch (IOException e) {
		            System.err.println("El archivo indicado no existe");
		        }
		    }
			generarMenu(ruta);
		
			break;
			
		case "mkfile":
			
			if(partido.length==1) {
				System.err.println("Debes introducir el nombre del archivo");
			}
			
			for (int i=1; i<partido.length; i++) {
				String rutaNueva=ruta+"\\"+partido[i];
				try {
					File fichero = new File (rutaNueva);
					if(fichero.exists()) {
						System.err.println("El fichero ya existe");
					}else {
					fichero.createNewFile();
					System.out.println("Fichero creado con éxito");
				} }catch (IOException e) {
				System.err.println("No se ha podido crear el fichero");
					
				}
				
			}
			generarMenu(ruta);
			
			break;
		case "write":
			if (partido.length==1) {
				System.out.println("Numero de argumentos no valido");
			}else {
				
		       if (!partido[1].endsWith(".txt")) {
		            System.err.println("El archivo debe tener una extensión .txt.");
		            generarMenu(ruta);
		        }
		       String rutaNueva=ruta+"\\"+partido[1];
				File fichero = new File (rutaNueva);
		       String textoAEscribir="";
		      
		       if (fichero.exists()) {
		       for (int i=2; i<partido.length;i++) {
		    	 textoAEscribir=textoAEscribir+" "+partido[i];
		       }
		       
		       
		        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true))) {
		            bw.write(textoAEscribir);
		            bw.newLine();
		            System.out.println("Texto escrito en el archivo.");
		        } catch (IOException e) {
		            System.err.println("El archivo no existe");
		            e.printStackTrace();
	
		        }
		      
		       }else {
		    	   System.err.println("El archivo no existe");
		       }
		        }
			
			generarMenu(ruta);
			
			
			break;
			
		case "dir":
			
			if(partido.length!=1) {
				System.err.println("Numero de argumentos no valido");
				generarMenu(ruta);
			}
			Path p = Path.of(ruta);
			
			try {
				Stream<Path> stream = Files.list(p);
				ArrayList<Path> lista = (ArrayList <Path>)stream.collect(Collectors.toList());
				
				for (Path item : lista) {
					File Fichero = new File(item.toString());
					long ms = Fichero.lastModified();
					Date d = new Date(ms);
					Calendar c = new GregorianCalendar(); 
					c.setTime(d);
					String[] archivo=item.toString().split("\\\\");
					
					if((c.get(Calendar.MINUTE))<10) {
					System.out.println(Integer.toString(c.get(Calendar.YEAR))+"/"+(Integer.toString(c.get(Calendar.MONTH)))+"/"+
					(Integer.toString(c.get(Calendar.DATE))+" "+Integer.toString(c.get(Calendar.HOUR_OF_DAY))+":0"+Integer.toString(c.get(Calendar.MINUTE))+"  "+archivo[archivo.length-1]));
					;
					}else {
					System.out.println(Integer.toString(c.get(Calendar.YEAR))+"/"+(Integer.toString(c.get(Calendar.MONTH)))+"/"+
					(Integer.toString(c.get(Calendar.DATE))+" "+Integer.toString(c.get(Calendar.HOUR_OF_DAY))+":"+Integer.toString(c.get(Calendar.MINUTE))+"  "+archivo[archivo.length-1]));
					}
				
					
				}
			}catch (NoSuchFileException e) {
			    System.err.println("El directorio especificado no existe: " + p.toString());
			    generarMenu(ruta);
			    
			} catch (IOException e) {
				generarMenu(ruta);
				e.printStackTrace();
			}
			generarMenu(ruta);
			
	
			break;
		case "readpoint":
		    if (partido.length != 3) {
	            System.err.println("Numero de argumentos no valido");
	            generarMenu(ruta);
	        }
try {
	        String nombreFichero = ruta+"\\"+partido[1];
	        long posicion = Long.parseLong(partido[2]);

	        try (RandomAccessFile archivo = new RandomAccessFile(nombreFichero, "r")) {
	            archivo.seek(posicion); 

	            int byteLeido;
	            while ((byteLeido = archivo.read()) != -1) {
	                System.out.print((char) byteLeido); 
	            }
	        } catch (IOException e) {
	           System.err.println("El archivo no existe");
	           generarMenu(ruta);
	        }}catch (NumberFormatException e) {
	        	System.err.println("La cadena no es un numero valido");
	        	generarMenu(ruta);
	        }
	        generarMenu(ruta);
	    
			break;
			

		case "delete":
			
		     if (partido.length != 2) {
		            System.err.println("Numero de argumentos no valido");
		            return;
		        }

		        String nombre = partido[1];

		        File archivoDirectorio = new File(nombre);

		        if (!archivoDirectorio.exists()) {
		            System.err.println("El archivo o directorio especificado no existe.");
		            generarMenu(ruta);
		        }

		            if (archivoDirectorio.isDirectory()) {
		            	archivoDirectorio.delete();
		            } else {

		                archivoDirectorio.delete();
		            }
		        
		            System.out.println("El archivo o directorio ha sido borrado correctamente.");

		    generarMenu(ruta);
		
			break;
		case "start":
			
			 if (partido.length != 2) {
		            System.err.println("Numero de argumentos no valido");
		            generarMenu(ruta);
		        }

		        String programa = partido[1];
		        ProcessBuilder processBuilder = new ProcessBuilder(programa);

		        try {
		            Process proceso = processBuilder.start();


		        } catch (IOException e) {
		           System.err.println("El proceso no existe");
		    }
		generarMenu(ruta);
			break;
		case "close":
			System.exit(0);
			break;
			
		case "clear":
	        for (int i = 0; i < 50; i++) {
	            System.out.println();
	        }
			generarMenu(ruta);
			break;
			
			default: 
				System.out.println("Comando no valido (usa help para ver los comandos)");
				generarMenu(ruta);
				break;
		}
	}

}
