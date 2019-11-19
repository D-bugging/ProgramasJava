package main;

//import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
//import javax.persistence.Query;
//import javax.transaction.Transaction;

import entity.Automovel;


public class PersistidorDeAutomovel {

	public static void main(String[] args) {
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		/*EntityManager em = JPAUtil.getEntityManager();*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		EntityManager em = emf.createEntityManager();

		/* Inserir */
				Automovel auto = new Automovel();
				auto.setMarca("Fiat");
				auto.setModelo("Uno");
				auto.setAnoFabricacao(2011);
				auto.setAnoModelo(2010);
				auto.setObservacoes("aff");

				EntityTransaction tx = em.getTransaction();
				tx.begin();
				em.persist(auto);
				tx.commit();
		 /**/

		/* Listar 
				Query q = em.createQuery("select a from Automovel a", Automovel.class);

				List<Automovel> autos = q.getResultList();
				for(Automovel a : autos) {
					System.out.println(a.getMarca());
				}
		 */

		/* Remover 
				EntityTransaction tx = em.getTransaction();
				Automovel auto = em.getReference(Automovel.class, 1);
				tx.begin();
				em.remove(auto);
				tx.commit();
		 */



		em.close();

		System.out.println("Termino");

	}

}
