package KCPD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO_hiber {
	public static void callme(DTO_hiber yt)
	{
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("project2");
		EntityManager em= emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(yt );
		et.commit();
	}
	


}
