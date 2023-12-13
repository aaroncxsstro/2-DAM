package Controladores;

import DAO.LibroDAO;
import Modelos.Autor;
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
            System.out.println("|| Id: :" + libro.getLibro_id() + "|| Titulo: "+libro.getTitulo()+ "|| Anio de publicacion: " + libro.getAnio_publicacion());
        } catch (Exception e) {
            System.err.println("Libro no encontrado");
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
                System.err.println("Libro no encontrado. No se puede eliminar.");
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
                System.out.println("Libro actual: || Id: :" + libro.getLibro_id() + "|| Titulo: "+libro.getTitulo()+ "|| Anio de publicacion: " + libro.getAnio_publicacion());

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
                System.err.println("Libro no encontrado. No se puede editar.");
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
    
    public void asociarLibroConAutor(int idLibro) {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Libro libro = session.get(Libro.class, idLibro);

            if (libro != null) {
                System.out.print("Ingrese el ID del Autor: ");
                int autorId = scanner.nextInt();
                scanner.nextLine();
                Autor autor = session.get(Autor.class, autorId);

                if (autor != null) {
                    libro.setAutor(autor);
                    session.update(libro);
                    System.out.println("Libro asociado con éxito al Autor.");
                } else {
                    System.err.println("Autor no encontrado. No se puede asociar el libro.");
                }
            } else {
                System.err.println("Libro no encontrado. No se puede asociar con un autor.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void comprobarNombreAutorPorLibro(int idLibro) {
        try {
            Libro libro = session.get(Libro.class, idLibro);

            if (libro != null && libro.getAutor() != null) {
                String nombreAutor = libro.getAutor().getNombre();
                System.out.println("Nombre del Autor del Libro con ID " + idLibro + ": " + nombreAutor);
            } else {
                System.err.println("Libro no encontrado o sin autor asignado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void LibroMenu(Session session, Scanner scanner) {
        LibroController libroController = new LibroController(session);
        boolean exit = false;

        while (!exit) {
            System.out.println("********Menú Libro********");
            System.out.println("1. Obtener Libro por ID");
            System.out.println("2. Añadir Libro");
            System.out.println("3. Editar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("5. Asociar Libro con Autor");
            System.out.println("6. Comprobar Nombre del Autor por Libro");
            System.out.println("7. Volver al Menú Principal");

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
                    System.out.print("Ingrese el ID del Libro a asociar con el Autor: "); 
                    int AsociarLibroId = scanner.nextInt();
                    scanner.nextLine();
                    libroController.asociarLibroConAutor(AsociarLibroId);
                    break;
                case 6:
                    System.out.print("Ingrese el ID del Libro para comprobar el nombre del autor: ");
                    int comprobarNombreAutorId = scanner.nextInt();
                    scanner.nextLine();
                    libroController.comprobarNombreAutorPorLibro(comprobarNombreAutorId);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.err.println("Opción no válida.");
        }
        }
    }
}
