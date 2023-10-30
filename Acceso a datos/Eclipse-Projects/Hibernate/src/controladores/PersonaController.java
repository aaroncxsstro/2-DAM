package controladores;

import dao.PersonaDAO;
import dao.Repository;
import modelos.Persona;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PersonaController implements Repository <Persona> {

    Session session = null;

    public PersonaController(Session session) {
        this.session = session;
    }

    @Override
    public Persona obtenerId(int id) {

        Transaction tx = null;
        Persona persona = null;

    try{
        tx = session.beginTransaction();
        persona = session.load(Persona.class, id);
        System.out.println("Persona buscada con éxito");
        //session.getTransaction().commit();
    }catch (Exception e){
        System.out.println("Persona no encontrada");
    }

    System.out.println(persona.toString());
    return persona;
}

    @Override
    public Persona eliminar(int id) {

        Persona p = null;
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            p = session.load(Persona.class, id);
            session.delete(p);
            session.getTransaction().commit();
            System.out.println("Persona P borrada");

        }catch (Exception e){
            System.err.println("Error, p");
            tx.rollback();
        }

        return p;
        }

}
