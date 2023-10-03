package objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {
	
		File file = new File ("ficheros/objeto");
		guardarObjeto(file);
		recuperarObjeto(file);

	}
	
	public static void guardarObjeto(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("El fichero"+ file.getName()+ " no se ha podido crear");
			e.printStackTrace();
		}
	
	
	Persona p = new Persona (1, "Eduardo", 20, "Calle mendivil");
	
	FileOutputStream fos = null;
	
	try {
		fos = new FileOutputStream (file);
	} catch (FileNotFoundException e) {
		System.out.println("No se ha podido encontrar el archivo "+ file.getName());
		e.printStackTrace();
	}
	
	ObjectOutputStream objectOutputStream = null;
	
	try {
		objectOutputStream = new ObjectOutputStream(fos);
		objectOutputStream.writeObject(p);
	} catch (IOException e) {
		System.out.println("No se ha podido encontrar el objectOutfit");
		e.printStackTrace();
	}

	try {
		fos.close();
		objectOutputStream.close();
	} catch (IOException e) {
		System.out.println("No se ha podido cerrar ");
		e.printStackTrace();
	}
}
	
	public static void recuperarObjeto (File file) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("No se puede abrir el inputStream");
			e.printStackTrace();
		}
		
		ObjectInputStream ois= null;
		
		try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			System.out.println("error al crear objeto InputStream");
			e.printStackTrace();
		}
		
		try {
			Persona p = (Persona) ois.readObject();
			System.out.println(p.toString());
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No se puede recuperar el objeto");
			e.printStackTrace();
		}
		
		try {
			fis.close();
			ois.close();
		} catch (IOException e) {
			System.out.println("No se han podido cerrar los objetos");
			e.printStackTrace();
		}
		
	}
	
}
