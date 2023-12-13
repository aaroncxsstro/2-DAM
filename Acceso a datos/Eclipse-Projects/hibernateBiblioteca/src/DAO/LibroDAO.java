package DAO;

import Modelos.Libro;

public interface LibroDAO {
    Libro obtenerLibro(int id);
    Libro eliminarLibro(int id);
    Libro añadirLibro();
    Libro editarLibro(int id);
}
