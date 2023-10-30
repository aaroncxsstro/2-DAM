package main;

import controladores.EmpresaController;
import controladores.PersonaController;
import org.hibernate.Session;
import utilidades.Utilidades;

public class Main {
    public static void main(String[] args) {

        Session session = Utilidades.getSessionFactory().openSession();

        PersonaController pc = new PersonaController(session);
        EmpresaController ec = new EmpresaController(session);

        pc.obtenerCLiente(1);
        ec.obtenerEmpresa(1);

        session.close();

    }
}
