package controladores;

import dao.EmpresaDAO;
import dao.Repository;
import modelos.Empresa;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmpresaController implements Repository <Empresa> {

    Session session = null;

    public EmpresaController(Session session) {
        this.session = session;
    }

    @Override
    public Empresa obtenerId(int id) {

        Transaction tx = null;
        Empresa empresa = null;

        try{

            tx = session.beginTransaction();
            empresa = session.load(Empresa.class, id);
            System.out.println("Empresa buscada con éxito");
            //session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Empresa no encontrada");
        }

        System.out.println(empresa.toString());
        return empresa;
    }

    @Override
    public Empresa eliminar(int id) {
        return null;
    }
}
