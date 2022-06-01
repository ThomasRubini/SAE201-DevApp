package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOActeur;
import fr.univ_amu.iut.model.Acteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAOActeurJPA extends DAOBaseClassJPA<Acteur> implements DAOActeur {

	public DAOActeurJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Acteur> findAll() {
		TypedQuery<Acteur> query = entityManager.createNamedQuery("Acteur.findAll", Acteur.class);
		return query.getResultList();
	}

	@Override
	public Acteur getById(int id) {
		TypedQuery<Acteur> query = entityManager.createNamedQuery("Acteur.findById", Acteur.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
