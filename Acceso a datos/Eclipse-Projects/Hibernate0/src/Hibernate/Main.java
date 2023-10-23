package Hibernate;

import org.hibernate.Session;

import utilidades.Utilidades;

public class Main {

	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();

		session.close();
	}

}
