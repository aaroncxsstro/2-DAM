package Juegos;

import java.util.*;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Main {
    public static void main(String[] args) {
        List<Juego> juegos = cargarJuegosDesdeXML("juegos.xml");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Eliminar un juego.");
            System.out.println("2. Añadir un juego.");
            System.out.println("3. Buscar un juego por un atributo.");
            System.out.println("4. Insertar un objeto juego en el XML.");
            System.out.println("5. Guardar y salir.");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    eliminarJuego(juegos, scanner);
                    break;
                case 2:
                    agregarJuego(juegos, scanner);
                    break;
                case 3:
                    buscarJuegoPorAtributo(juegos, scanner);
                    break;
                case 4:
                    insertarJuegoEnXML(juegos, scanner, "juegos.xml");
                    break;
                case 5:
                    guardarJuegosEnXML(juegos, "juegos.xml");
                    System.out.println("Guardando y saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static List<Juego> cargarJuegosDesdeXML(String archivoXML) {
        List<Juego> juegos = new ArrayList<>();
        try {
            File archivo = new File(archivoXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList listaDeJuegos = documento.getElementsByTagName("juego");

            for (int i = 0; i < listaDeJuegos.getLength(); i++) {
                Node nodoJuego = listaDeJuegos.item(i);
                if (nodoJuego.getNodeType() == Node.ELEMENT_NODE) {
                    Element elementoJuego = (Element) nodoJuego;
                    String titulo = elementoJuego.getElementsByTagName("titulo").item(0).getTextContent();
                    String genero = elementoJuego.getElementsByTagName("genero").item(0).getTextContent();
                    String plataforma = elementoJuego.getElementsByTagName("plataforma").item(0).getTextContent();
                    String fechaLanzamiento = elementoJuego.getElementsByTagName("fechadelanzamiento").item(0).getTextContent();
                    Juego juego = new Juego(titulo, genero, plataforma, fechaLanzamiento);
                    juegos.add(juego);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return juegos;
    }

    public static void eliminarJuego(List<Juego> juegos, Scanner scanner) {
        System.out.print("Ingrese el título del juego a eliminar: ");
        String tituloEliminar = scanner.nextLine();

        Iterator<Juego> iterator = juegos.iterator();
        while (iterator.hasNext()) {
            Juego juego = iterator.next();
            if (juego.getTitulo().equalsIgnoreCase(tituloEliminar)) {
                iterator.remove();
                System.out.println("Juego eliminado con éxito.");
                return;
            }
        }
        System.out.println("El juego no fue encontrado en la lista.");
    }

    public static void agregarJuego(List<Juego> juegos, Scanner scanner) {
        System.out.print("Ingrese el título del juego: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el género del juego: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese la plataforma del juego: ");
        String plataforma = scanner.nextLine();
        System.out.print("Ingrese la fecha de lanzamiento del juego: ");
        String fechaLanzamiento = scanner.nextLine();

        Juego nuevoJuego = new Juego(titulo, genero, plataforma, fechaLanzamiento);
        juegos.add(nuevoJuego);
        System.out.println("Juego agregado con éxito.");
    }

    public static void buscarJuegoPorAtributo(List<Juego> juegos, Scanner scanner) {
        System.out.println("Seleccione el atributo por el cual desea buscar:");
        System.out.println("1. Título");
        System.out.println("2. Género");
        System.out.println("3. Plataforma");
        System.out.println("4. Fecha de lanzamiento");

 
        int opcion = scanner.nextInt();
        String valorBuscar = scanner.nextLine();

        switch (opcion) {
            case 1:
                buscarPorAtributo(juegos, "titulo", valorBuscar);
                break;
            case 2:
                buscarPorAtributo(juegos, "genero", valorBuscar);
                break;
            case 3:
                buscarPorAtributo(juegos, "plataforma", valorBuscar);
                break;
            case 4:
                buscarPorAtributo(juegos, "fechaLanzamiento", valorBuscar);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void buscarPorAtributo(List<Juego> juegos, String atributo, String valorBuscar) {
        for (Juego juego : juegos) {
            String valorAtributo = null;
            switch (atributo) {
                case "titulo":
                    valorAtributo = juego.getTitulo();
                    break;
                case "genero":
                    valorAtributo = juego.getGenero();
                    break;
                case "plataforma":
                    valorAtributo = juego.getPlataforma();
                    break;
                case "fechaLanzamiento":
                    valorAtributo = juego.getFechaLanzamiento();
                    break;
                default:
                    System.out.println("Atributo no válido.");
                    return;
            }

            if (valorAtributo != null && valorAtributo.equalsIgnoreCase(valorBuscar)) {
                System.out.println("Juego encontrado:");
                System.out.println(juego);
                return;
            }
        }
        System.out.println("Ningún juego coincide con el valor del atributo proporcionado.");
    }

    public static void insertarJuegoEnXML(List<Juego> juegos, Scanner scanner, String archivoXML) {
        try {
            File archivo = new File(archivoXML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.parse(archivo);
            documento.getDocumentElement().normalize();

            Element listaDeJuegos = documento.getDocumentElement();

            for (Juego juego : juegos) {
                Element juegoElemento = documento.createElement("juego");

                Element tituloElemento = documento.createElement("titulo");
                tituloElemento.appendChild(documento.createTextNode(juego.getTitulo()));
                juegoElemento.appendChild(tituloElemento);

                Element generoElemento = documento.createElement("genero");
                generoElemento.appendChild(documento.createTextNode(juego.getGenero()));
                juegoElemento.appendChild(generoElemento);

                Element plataformaElemento = documento.createElement("plataforma");
                plataformaElemento.appendChild(documento.createTextNode(juego.getPlataforma()));
                juegoElemento.appendChild(plataformaElemento);

                Element fechaLanzamientoElemento = documento.createElement("fechadelanzamiento");
                fechaLanzamientoElemento.appendChild(documento.createTextNode(juego.getFechaLanzamiento()));
                juegoElemento.appendChild(fechaLanzamientoElemento);

                listaDeJuegos.appendChild(juegoElemento);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(archivoXML));
            transformer.transform(source, result);

            System.out.println("Lista de juegos actualizada en " + archivoXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void guardarJuegosEnXML(List<Juego> juegos, String archivoXML) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.newDocument();

            Element listaDeJuegos = documento.createElement("listadejuegos");
            documento.appendChild(listaDeJuegos);

            for (Juego juego : juegos) {
                Element juegoElemento = documento.createElement("juego");

                Element tituloElemento = documento.createElement("titulo");
                tituloElemento.appendChild(documento.createTextNode(juego.getTitulo()));
                juegoElemento.appendChild(tituloElemento);

                Element generoElemento = documento.createElement("genero");
                generoElemento.appendChild(documento.createTextNode(juego.getGenero()));
                juegoElemento.appendChild(generoElemento);

                Element plataformaElemento = documento.createElement("plataforma");
                plataformaElemento.appendChild(documento.createTextNode(juego.getPlataforma()));
                juegoElemento.appendChild(plataformaElemento);

                Element fechaLanzamientoElemento = documento.createElement("fechadelanzamiento");
                fechaLanzamientoElemento.appendChild(documento.createTextNode(juego.getFechaLanzamiento()));
                juegoElemento.appendChild(fechaLanzamientoElemento);

                listaDeJuegos.appendChild(juegoElemento);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File(archivoXML));
            transformer.transform(source, result);

            System.out.println("Lista de juegos guardada en " + archivoXML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
