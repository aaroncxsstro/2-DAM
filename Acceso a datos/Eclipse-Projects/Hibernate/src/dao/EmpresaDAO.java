package dao;

import modelos.Empresa;

public interface EmpresaDAO {

    public Empresa obtenerEmpresa(int id);
    public void eliminarEmpresa(int id);
}
