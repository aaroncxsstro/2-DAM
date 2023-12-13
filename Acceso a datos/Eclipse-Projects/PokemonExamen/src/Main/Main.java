package Main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Scanner scanner = new Scanner(System.in);


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
                	break;
                case 2:
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
