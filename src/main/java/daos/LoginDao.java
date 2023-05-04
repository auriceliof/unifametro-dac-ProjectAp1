package daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


import entities.Usuario;
import utils.JPAUtil;

public class LoginDao {
	
public Usuario getUsuario(String nomeUsuario, String senha) {
		
		EntityManager em = JPAUtil.creatingEntityManager();

		try {
			Usuario usuario = (Usuario) em
				.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha ")
				.setParameter("name", nomeUsuario)
				.setParameter("senha", senha)
				.getSingleResult();

			return usuario;

		} catch (NoResultException e) {
			return null;
		}
	}
}
