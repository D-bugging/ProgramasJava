package bean;

//import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence; // testando
//import javax.persistence.Query;

import entity.Automovel;

// Classe que contém método para gravação, tipo DAO
@ManagedBean
public class AutomovelBean {
	private Automovel automovel = new Automovel();
	//private List<Automovel> automoveis;

	public Automovel getAutomovel() {
		return this.automovel;
	}
	/*
	 A partir da Expression Language 2.2, utilizado pelo JBoss 7 e o Tomcat 7
	 nao precisamos mais do setter. Com isso, e possivel fazer com que o metodo definido na 'action' do botao receba o parametro
	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	 */

	// Ao clicar no botao Salvar (cadastraAutomoveis.xhtml) esse metodo deve ser chamado
	public void salva(Automovel automovel) {

		// Conseguindo a EntityManager
		//EntityManager em = JPAUtil.getEntityManager();
		
		/* Testando */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(this.automovel);
		tx.commit();
		em.close();
	}

/*
	// Listar os valores
	public List<Automovel> getAutomoveis(){
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Automovel a", Automovel.class);

		this.automoveis = q.getResultList();
		em.close();
		return automoveis;
	}
*/
}