package DAO;

import Modelos.Genero;

public interface GeneroDAO {
    Genero obtenerGenero(int id);
    Genero eliminarGenero(int id);
    Genero añadirGenero();
    Genero editarGenero(int id);
}