package daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.Email;
import utils.JPAUtil;

public class EmailDao {
	
	public static void salvar(Email e) {
		
		EntityManager em = JPAUtil.creatingEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Email e) {
		EntityManager em = JPAUtil.creatingEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}

	public static void deletar(Email e) {
		
		EntityManager em = JPAUtil.creatingEntityManager();
		em.getTransaction().begin();
		e = em.find(Email.class, e.getId());
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public static List<Email> listarTodos() {
		
		EntityManager em = JPAUtil.creatingEntityManager();
		Query q = em.createQuery("select e from Email e");
		@SuppressWarnings("unchecked")
		List<Email> list = q.getResultList();
		em.close();
		return list;
	}
	
	
	public static Email listarPorId(Integer id) {
	
		EntityManager em = JPAUtil.creatingEntityManager();
		em.getTransaction().begin();
		Email e = em.find(Email.class, id);
		em.close();
		return e;
	}	
}
