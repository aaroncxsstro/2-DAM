package DAO;

import Modelos.Autor;

public interface AutorDAO {
    Autor obtenerAutor(int id);
    Autor eliminarAutor(int id);
    Autor anadirAutor();
    Autor editarAutor(int id);
    
}