package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ap1PU");
	
	public static EntityManager creatingEntityManager() {
		return emf.createEntityManager();
	}
}
