import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class ListFiles {

	public static void main(String[] args) {
		
		Path path = Path.of("ficheros");
		listarArchivos(path);

	}
	
	public static void listarArchivos (Path p) {
		
	try {
		Stream<Path> stream = Files.list(p);
		ArrayList<Path> lista = (ArrayList <Path>)stream.collect(Collectors.toList());
		for (Path item : lista) {
			System.out.println(item);
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
