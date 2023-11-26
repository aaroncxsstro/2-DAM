package Controladores;

import DAO.GeneroDAO;
import Modelos.Genero;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class GeneroController implements GeneroDAO {

    private Session session;
    private Scanner scanner;

    public GeneroController(Session session) {
        this.session = session;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Genero obtenerGenero(int id) {
        Transaction tx = null;
        Genero genero = null;
        try {
            tx = session.beginTransaction();
            genero = session.get(Genero.class, id);
            System.out.println("Género obtenido con éxito: " + genero);
        } catch (Exception e) {
            System.out.println("Género no encontrado");
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return genero;
    }

    @Override
    public Genero eliminarGenero(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Genero genero = session.get(Genero.class, id);
            if (genero != null) {
                session.delete(genero);
                System.out.println("Género eliminado con éxito");
            } else {
                System.out.println("Género no encontrado. No se puede eliminar.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Genero añadirGenero() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Genero nuevoGenero = new Genero();

            System.out.println("Ingrese el nombre del género:");
            String nombre = scanner.nextLine();
            nuevoGenero.setNombre(nombre);

            session.save(nuevoGenero);
            System.out.println("Género añadido con éxito");
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Genero editarGenero(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Genero genero = session.get(Genero.class, id);
            if (genero != null) {
                System.out.println("Género actual: " + genero);

                System.out.println("Ingrese el nuevo nombre del género (o presione Enter para dejarlo sin cambios):");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    genero.setNombre(nuevoNombre);
                }

                session.update(genero);
                System.out.println("Género editado con éxito");
            } else {
                System.out.println("Género no encontrado. No se puede editar.");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public static void GeneroMenu(Session session, Scanner scanner) {
        GeneroController generoController = new GeneroController(session);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menú Género ===");
            System.out.println("1. Obtener Género por ID");
            System.out.println("2. Añadir Género");
            System.out.println("3. Editar Género");
            System.out.println("4. Eliminar Género");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el ID del Género: ");
                    int generoId = scanner.nextInt();
                    scanner.nextLine();
                    generoController.obtenerGenero(generoId);
                    break;
                case 2:
                    generoController.añadirGenero();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del Género a editar: ");
                    int editGeneroId = scanner.nextInt();
                    scanner.nextLine();
                    generoController.editarGenero(editGeneroId);
                    break;
                case 4:
                    System.out.print("Ingrese el ID del Género a eliminar: ");
                    int deleteGeneroId = scanner.nextInt();
                    scanner.nextLine();
                    generoController.eliminarGenero(deleteGeneroId);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
