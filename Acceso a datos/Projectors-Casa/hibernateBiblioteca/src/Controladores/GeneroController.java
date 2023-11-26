package Controladores;

import DAO.GeneroDAO;
import Modelos.Genero;
import Modelos.Libro;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
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
            System.out.println("|| Id: " + genero.getGenero_id() + "|| Nombre: "+genero.getNombre());
        } catch (Exception e) {
            System.err.println("Género no encontrado");
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
                System.err.println("Género no encontrado.");
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

    public Genero añadirGenero() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Genero nuevoGenero = new Genero();

            System.out.println("Ingrese el nombre del género:");
            String nombre = scanner.nextLine();
            nuevoGenero.setNombre(nombre);

            // Create a list to store books
            List<Libro> libros = new ArrayList<>();

            // Prompt user to add books indefinitely
            while (true) {
                System.out.println("Ingrese el ID del libro a añadir al género (o deje en blanco para finalizar):");
                String libroIdInput = scanner.nextLine().trim();

                if (libroIdInput.isEmpty()) {
                    break; // Exit the loop if the input is empty
                }

                try {
                    int libroId = Integer.parseInt(libroIdInput);
                    Libro libro = session.get(Libro.class, libroId);

                    if (libro != null) {
                        libros.add(libro);
                    } else {
                        System.err.println("Libro no encontrado. Inténtelo de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("ID de libro no válido. Inténtelo de nuevo.");
                }
            }

            nuevoGenero.setLibros(libros); // Set the list of books for the genre

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
                System.out.println("Género actual: || Id: " + genero.getGenero_id() + "|| Nombre: "+genero.getNombre());

                System.out.println("Ingrese el nuevo nombre del género (o presione Enter para dejarlo sin cambios):");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    genero.setNombre(nuevoNombre);
                }

                session.update(genero);
                System.out.println("Género editado con éxito");
            } else {
                System.err.println("Género no encontrado. No se puede editar.");
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

    public void asociarLibrosAGenero() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            System.out.println("Ingrese el ID del Género al que desea asociar libros:");
            int generoId = scanner.nextInt();
            scanner.nextLine();

            Genero genero = session.get(Genero.class, generoId);

            if (genero != null) {
                List<Libro> libros = new ArrayList<>();

                while (true) {
                    System.out.println("Ingrese el ID del libro a añadir al género (o deje en blanco para finalizar):");
                    String libroIdInput = scanner.nextLine().trim();

                    if (libroIdInput.isEmpty()) {
                        break; // Exit the loop if the input is empty
                    }

                    try {
                        int libroId = Integer.parseInt(libroIdInput);
                        Libro libro = session.get(Libro.class, libroId);

                        if (libro != null) {
                            libros.add(libro);
                        } else {
                            System.err.println("Libro no encontrado. Inténtelo de nuevo.");
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("ID de libro no válido. Inténtelo de nuevo.");
                    }
                }

                genero.getLibros().addAll(libros);
                session.update(genero);

                System.out.println("Libros asociados con éxito al Género.");
            } else {
                System.err.println("Género no encontrado. No se pueden asociar libros.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void obtenerLibrosPorGenero(int idGenero) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Genero genero = session.get(Genero.class, idGenero);

            if (genero != null) {
                List<Libro> libros = genero.getLibros();

                if (!libros.isEmpty()) {
                    System.out.println("Libros asociados al Género con ID " + idGenero + ":");
                    for (Libro libro : libros) {
                        System.out.println("ID: " + libro.getLibro_id() + " | Título: " + libro.getTitulo());
                    }
                } else {
                    System.out.println("No hay libros asociados a este Género.");
                }
            } else {
                System.err.println("Género no encontrado. No se pueden obtener los libros asociados.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    
    public static void GeneroMenu(Session session, Scanner scanner) {
        GeneroController generoController = new GeneroController(session);
        boolean exit = false;

        while (!exit) {
            System.out.println("********Menú Género********");
            System.out.println("1. Obtener Género por ID");
            System.out.println("2. Añadir Género");
            System.out.println("3. Editar Género");
            System.out.println("4. Eliminar Género");
            System.out.println("5. Asociar Genero con Libros");
            System.out.println("6. Comprobar los libros asociados a un genero");
            System.out.println("7. Volver al Menú Principal");
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
                	generoController.asociarLibrosAGenero();
                	break;
                case 6: 
                	System.out.print("Ingrese el ID del Género del que mostrar los libros: ");
                   int idGeneroLibros = scanner.nextInt();
                       scanner.nextLine();
                	generoController.obtenerLibrosPorGenero(idGeneroLibros);
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
