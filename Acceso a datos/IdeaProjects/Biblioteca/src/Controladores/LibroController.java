package Controladores;

import DAO.LibroDAO;
import Modelos.Libro;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class LibroController implements LibroDAO {

    private Session session;
    private Scanner scanner;

    public LibroController(Session session) {
        this.session = session;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Libro obtenerLibro(int id) {
        Transaction tx = null;
        Libro libro = null;
        try {
            tx = session.beginTransaction();
            libro = session.get(Libro.class, id);
            System.out.println("Libro obtenido con éxito: " + libro);
        } catch (Exception e) {
            System.out.println("Libro no encontrado");
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return libro;
    }

    @Override
    public Libro eliminarLibro(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Libro libro = session.get(Libro.class, id);
            if (libro != null) {
                session.delete(libro);
                System.out.println("Libro eliminado con éxito");
            } else {
                System.out.println("Libro no encontrado. No se puede eliminar.");
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
    public Libro añadirLibro() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Libro nuevoLibro = new Libro();

            System.out.println("Ingrese el título del libro:");
            String titulo = scanner.nextLine();
            nuevoLibro.setTitulo(titulo);

            System.out.println("Ingrese el año de publicación del libro:");
            String anioPublicacion = scanner.nextLine();
            nuevoLibro.setAnio_publicacion(anioPublicacion);

            session.save(nuevoLibro);
            System.out.println("Libro añadido con éxito");
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
    public Libro editarLibro(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Libro libro = session.get(Libro.class, id);
            if (libro != null) {
                System.out.println("Libro actual: " + libro);

                System.out.println("Ingrese el nuevo título del libro (o presione Enter para dejarlo sin cambios):");
                String nuevoTitulo = scanner.nextLine();
                if (!nuevoTitulo.isEmpty()) {
                    libro.setTitulo(nuevoTitulo);
                }

                System.out.println("Ingrese el nuevo año de publicación del libro (o presione Enter para dejarlo sin cambios):");
                String nuevoAnioPublicacion = scanner.nextLine();
                if (!nuevoAnioPublicacion.isEmpty()) {
                    libro.setAnio_publicacion(nuevoAnioPublicacion);
                }

                session.update(libro);
                System.out.println("Libro editado con éxito");
            } else {
                System.out.println("Libro no encontrado. No se puede editar.");
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

    public static void LibroMenu(Session session, Scanner scanner) {
        LibroController libroController = new LibroController(session);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menú Libro ===");
            System.out.println("1. Obtener Libro por ID");
            System.out.println("2. Añadir Libro");
            System.out.println("3. Editar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el ID del Libro: ");
                    int libroId = scanner.nextInt();
                    scanner.nextLine();
                    libroController.obtenerLibro(libroId);
                    break;
                case 2:
                    libroController.añadirLibro();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del Libro a editar: ");
                    int editLibroId = scanner.nextInt();
                    scanner.nextLine();
                    libroController.editarLibro(editLibroId);
                    break;
                case 4:
                    System.out.print("Ingrese el ID del Libro a eliminar: ");
                    int deleteLibroId = scanner.nextInt();
                    scanner.nextLine();
                    libroController.eliminarLibro(deleteLibroId);
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
