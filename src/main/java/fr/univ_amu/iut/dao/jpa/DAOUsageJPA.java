package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Usage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAOUsageJPA extends DAOBaseClassJPA<Usage> implements DAOUsage {

	public DAOUsageJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Usage> findAll() {
		TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findAll", Usage.class);
		return query.getResultList();
	}

	@Override
	public Usage getById(int id) {
		TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findById", Usage.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
