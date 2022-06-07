package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAO;
import jakarta.persistence.EntityManager;


// Helper class to reduce code duplication
public abstract class DAOBaseClassJPA<T> implements DAO<T> {

	protected EntityManager entityManager;

	public DAOBaseClassJPA(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean insert(T etudiant) {
		entityManager.getTransaction().begin();
		entityManager.persist(etudiant);
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean update(T obj) {
		entityManager.getTransaction().begin();
		entityManager.merge(obj);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public boolean delete(T obj) {
		entityManager.getTransaction().begin();
		entityManager.remove(obj);
		entityManager.getTransaction().commit();

		return true;
	}
}
