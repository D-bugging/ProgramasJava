package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Classe para garantir que o EntityManagerFactory seja criada apenas uma vez

public class JPAUtil {
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}