package dao;

import modelos.Persona;

public interface PersonaDAO {

    public Persona obtenerCLiente(int id);
    public void eliminarCliente(int id);
}
