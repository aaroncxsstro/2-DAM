import Controladores.AutorController;
import Controladores.GeneroController;
import Controladores.LibroController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Scanner scanner = new Scanner(System.in);
        AutorController autorController = new AutorController(session);
        GeneroController generoController = new GeneroController(session);
        LibroController libroController = new LibroController(session);

        boolean exit = false;

        while (!exit) {
            System.out.println("*****Menú Principal*****");
            System.out.println("1. Zona Autor");
            System.out.println("2. Zona Género");
            System.out.println("3. Zona Libro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    AutorController.AutorMenu(session, scanner);
                    break;
                case 2:
                    GeneroController.GeneroMenu(session, scanner);
                    break;
                case 3:
                    LibroController.LibroMenu(session, scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        session.close();
        sessionFactory.close();
        scanner.close();
    }
}
