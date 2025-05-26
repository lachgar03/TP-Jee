package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import dao.EtudiantDaoMySQL;
//import dao.IEtudiantDao;
import domain.Etudiant;

public class Test {
//	public static void main(String[] args) {
//		IEtudiantDao dao= new EtudiantDaoMySQL();
//		dao.add(new Etudiant("A1", "nom1", "ville1", 20));
//		dao.add(new Etudiant("A2", "nom3", "ville2", 19));
//		dao.add(new Etudiant("11", "nom2", "ville3", 22));
//		for(Etudiant e: dao.findAll()) System.out.println(e);
//		IEtudiantDao dao1= new EtudiantDaoMySQL();
//		dao1.add(new Etudiant("C1", "nom5", "ville5", 20));
//		System.out.println("------------------------------");
//		for(Etudiant e: dao1.findAll()) System.out.println(e);
//		dao.delete("A2");
//		System.out.println("------------------------------");
//		for(Etudiant e: dao1.findAll()) System.out.println(e);
//		System.out.println(dao.findByCode("A1"));
//		}
	
	public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GS-ET");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(new Etudiant("C1", "nom5", "ville5", 20));
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
