import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
      String sistemsOP = System.getProperty("os.name");
      if (sistemsOP.equals("Linux") ) {
          ProcessBuilder pb = new ProcessBuilder("ls", "user.dir");
          Process ps;
          try {
              ps = pb.start();
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));

          String linea;
          while (true) {
              try {
                  if (!((linea = reader.readLine()) != null)) break;
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
              System.out.println(linea);
          }

          ps.destroy();
          System.out.println("Proceso finalizado");
      } else if (sistemsOP.equals("Windows 11") ) {

          ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir");
          Process ps;
          try {
              ps = pb.start();
          } catch (IOException e) {
              throw new RuntimeException(e);
          }
          BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));

          String linea;
          while (true) {
              try {
                  if (!((linea = reader.readLine()) != null)) break;
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
              System.out.println(linea);
          }

          ps.destroy();
          System.out.println("Proceso finalizado");

      }
    }
}