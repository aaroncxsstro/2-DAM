package Ficheros;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;




public class Fichero_uno {

	public static void main(String[] args) {

		//Crear directorio
		System.out.println("Iniciando programa");
		File directorio = new File ("ficheros");
		
		if(!directorio.mkdir()) {
			System.out.println("Error al crear el programa");
		}else {
			System.out.println("Directorio creado con éxito");
		}
		
		//Crear fichero
		File fichero = new File ("ficheros/ficheros.txt");
		
		try {
			fichero.createNewFile();
			System.out.println("Fichero creado con éxito");
		} catch (IOException e) {
		System.out.println("No se ha podido crear el fichero");
			e.printStackTrace();
		}

		//Renombrar fichero
		
		File renombre = new File(directorio,"fichero_copia.txt");
		fichero.renameTo(renombre);
		System.out.println("Fichero renombrado");
		
		//Copia ficheros FileUtils
		
		//Copia el fichero renombre en el fichero llamado fichero
		
	try {
		FileUtils.copyFile(renombre,fichero);
		System.out.println("Fichero copiado");
	} catch (IOException e) {
		System.out.println("No se ha podido copiar el fichero "+ renombre.getName());
		e.printStackTrace();
	}
	
	//Mueve fichero a un archivo llamado ficheroMovido situado en este caso en la raiz del proyecto
		
	try {
		FileUtils.moveFile(fichero, new File ("ficheroMovido.txt"));
	} catch (IOException e) {
		System.out.println("No se ha podido mover el archivo "+ fichero.getName());
		e.printStackTrace();
	}
	
	//Borrar fichero
	
	File ficheroBorrar = new File(directorio, "ficheroBorrar.txt");
	
	try {
		ficheroBorrar.createNewFile();
		System.out.println("Fichero creado con éxito");
	} catch (IOException e) {
		System.out.println("Error al crear el fichero");
		e.printStackTrace();
	}
	
	if(ficheroBorrar.delete()) {
		System.out.println("Fichero "+ ficheroBorrar.getName() + " borrado con éxito");
	}else {
		System.out.println("Error al borrar el fichero "+ ficheroBorrar.getName());
	}
	}

}
