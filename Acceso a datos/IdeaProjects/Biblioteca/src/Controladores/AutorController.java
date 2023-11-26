package Controladores;

import DAO.AutorDAO;
import Modelos.Autor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class AutorController implements AutorDAO {

    private Session session;
    private Scanner scanner;

    public AutorController(Session session) {
        this.session = session;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Autor obtenerAutor(int id) {
        Transaction tx = null;
        Autor autor = null;
        try {
            tx = session.beginTransaction();
            autor = session.get(Autor.class, id);
            System.out.println("Autor obtenido con éxito: " + autor);
        } catch (Exception e) {
            System.out.println("Autor no encontrado");
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
        return autor;
    }

    @Override
    public Autor eliminarAutor(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Autor autor = session.get(Autor.class, id);
            if (autor != null) {
                session.delete(autor);
                System.out.println("Autor eliminado con éxito");
            } else {
                System.out.println("Autor no encontrado. No se puede eliminar.");
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
    public Autor anadirAutor() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Autor nuevoAutor = new Autor();

            System.out.println("Ingrese el nombre del autor:");
            String nombre = scanner.nextLine();
            nuevoAutor.setNombre(nombre);

            System.out.println("Ingrese la nacionalidad del autor:");
            String nacionalidad = scanner.nextLine();
            nuevoAutor.setNacionalidad(nacionalidad);

            session.save(nuevoAutor);
            System.out.println("Autor añadido con éxito");
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
    public Autor editarAutor(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Autor autor = session.get(Autor.class, id);
            if (autor != null) {
                System.out.println("Autor actual: " + autor);

                System.out.println("Ingrese el nuevo nombre del autor (o presione Enter para dejarlo sin cambios):");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    autor.setNombre(nuevoNombre);
                }

                System.out.println("Ingrese la nueva nacionalidad del autor (o presione Enter para dejarla sin cambios):");
                String nuevaNacionalidad = scanner.nextLine();
                if (!nuevaNacionalidad.isEmpty()) {
                    autor.setNacionalidad(nuevaNacionalidad);
                }

                session.update(autor);
                System.out.println("Autor editado con éxito");
            } else {
                System.out.println("Autor no encontrado. No se puede editar.");
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

    public static void AutorMenu(Session session, Scanner scanner) {
        AutorController autorController = new AutorController(session);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menú Autor ===");
            System.out.println("1. Obtener Autor por ID");
            System.out.println("2. Añadir Autor");
            System.out.println("3. Editar Autor");
            System.out.println("4. Eliminar Autor");
            System.out.println("5. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el ID del Autor: ");
                    int autorId = scanner.nextInt();
                    scanner.nextLine();
                    autorController.obtenerAutor(autorId);
                    break;
                case 2:
                    autorController.anadirAutor();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del Autor a editar: ");
                    int editAutorId = scanner.nextInt();
                    scanner.nextLine();
                    autorController.editarAutor(editAutorId);
                    break;
                case 4:
                    System.out.print("Ingrese el ID del Autor a eliminar: ");
                    int deleteAutorId = scanner.nextInt();
                    scanner.nextLine();
                    autorController.eliminarAutor(deleteAutorId);
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
