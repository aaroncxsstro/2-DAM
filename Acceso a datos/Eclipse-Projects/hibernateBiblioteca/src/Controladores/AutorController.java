package Controladores;

import DAO.AutorDAO;
import Modelos.Autor;
import Modelos.Genero;

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
            System.out.println("|| Id: " + autor.getId_autor() + "|| Nombre: "+autor.getNombre()+ "|| Nacionalidad: " + autor.getNacionalidad());
        } catch (Exception e) {
            System.err.println("El autor no existe");
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
                System.out.println("Autor eliminado");
            } else {
                System.err.println("El autor no existe.");
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
                System.out.println("Autor actual: || Id: " + autor.getId_autor() + "|| Nombre: "+autor.getNombre()+ "|| Nacionalidad: " + autor.getNacionalidad());

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
                System.err.println("Autor no encontrado. No se puede editar.");
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

    public void asociarAutorConGenero(int idAutor) {
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Autor autor = session.get(Autor.class, idAutor);

            if (autor != null) {
                System.out.print("Ingrese el ID del Genero: ");
                int generoId = scanner.nextInt();
                scanner.nextLine();
                Genero genero = session.get(Genero.class, generoId);

                if (genero != null) {
                    autor.setGenero(genero);
                    session.update(autor);
                    System.out.println("Autor asociado con éxito al Genero.");
                } else {
                    System.err.println("Genero no encontrado. No se puede asociar el autor.");
                }
            } else {
                System.err.println("Autor no encontrado. No se puede asociar con un Genero.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void comprobarNombreGeneroPorAutor(int idAutor) {
        try {
            Autor autor = session.get(Autor.class, idAutor);

            if (autor != null && autor.getGenero() != null) {
                String nombreGenero = autor.getGenero().getNombre();
                System.out.println("Nombre del Genero del Autor con ID " + idAutor + ": " + nombreGenero);
            } else {
                System.err.println("Autor no encontrado o sin genero asignado.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void AutorMenu(Session session, Scanner scanner) {
        AutorController autorController = new AutorController(session);
        boolean exit = false;

        while (!exit) {
            System.out.println("********Menú Autor********");
            System.out.println("1. Obtener Autor por ID");
            System.out.println("2. Añadir Autor");
            System.out.println("3. Editar Autor");
            System.out.println("4. Eliminar Autor");
            System.out.println("5. Asociar Autor con Genero");
            System.out.println("6. Comprobar Nombre del Genero por Autor");
            System.out.println("7. Volver al Menú Principal");
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
                    System.out.print("Ingrese el ID del Autor a asociar con el Genero: "); 
                    int AsociarAutorId = scanner.nextInt();
                    scanner.nextLine();
                    autorController.asociarAutorConGenero(AsociarAutorId);
                    break;
                case 6:
                    System.out.print("Ingrese el ID del Autor para comprobar el genero que escribe: ");
                    int comprobarNombreGeneroId = scanner.nextInt();
                    scanner.nextLine();
                    autorController.comprobarNombreGeneroPorAutor(comprobarNombreGeneroId);
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
