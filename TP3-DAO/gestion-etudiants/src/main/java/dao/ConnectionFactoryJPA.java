package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConnectionFactoryJPA {
	private ConnectionFactoryJPA() {}
	private static EntityManagerFactory emf=null;
	public static EntityManager getEntityManager(){
	if (emf == null){
	emf = Persistence.createEntityManagerFactory("GS-ET");
	}
	return emf.createEntityManager();
}
}
