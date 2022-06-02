package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.model.Ressource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAORessourceJPA extends DAOBaseClassJPA<Ressource> implements DAORessource {

	public DAORessourceJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Ressource> findAll() {
		TypedQuery<Ressource> query = entityManager.createNamedQuery("Ressource.findAll", Ressource.class);
		return query.getResultList();
	}

	@Override
	public Ressource getById(int id) {
		TypedQuery<Ressource> query = entityManager.createNamedQuery("Ressource.findById", Ressource.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
