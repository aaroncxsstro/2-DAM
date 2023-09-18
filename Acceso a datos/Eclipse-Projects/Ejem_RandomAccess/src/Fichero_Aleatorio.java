
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Fichero_Aleatorio {

	public static void main(String[] args) {
	
		File file = new File ("ficheros/aleatorio.txt");
		
		RandomAccessFile randomAccessFile = null;
		
		try {
			randomAccessFile = new RandomAccessFile(file, "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pointer(randomAccessFile);
		escribir(randomAccessFile, "Hola Mundo");
		pointer(randomAccessFile);
		seek (randomAccessFile, 3);
		leer(randomAccessFile);
		pointer(randomAccessFile);
		leer(randomAccessFile);
		seek(randomAccessFile, 6);
		escribir(randomAccessFile, "Java");
		leer(randomAccessFile);
		seek(randomAccessFile, 2);
		leer(randomAccessFile);
	}
	


	public static void escribir(RandomAccessFile raf, String texto) {
		System.out.println("Escribiendo....");
		try {
			raf.writeBytes(texto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void leer(RandomAccessFile raf) {
		System.out.println("Leyendo....");
		
		String linea;
		try {
			while ((linea = raf.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			System.out.println("No se ha podido leer el documento");
			e.printStackTrace();
		}
	}
	
	public static void pointer(RandomAccessFile raf) {
		try {
			System.out.println("Posicion: "+ raf.getFilePointer());
		} catch (IOException e) {
			System.out.println("No se ha podido comprobar la ubicacion del puntero");
			e.printStackTrace();
		}
	}
	
	public static void seek(RandomAccessFile raf, int pos) {
		try {
			raf.seek(pos);
		} catch (IOException e) {
			System.out.println("No se ha podido establecer la ubicacion del puntero");
			e.printStackTrace();
		}
	}
	
}
