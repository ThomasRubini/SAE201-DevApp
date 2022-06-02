package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Usages;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOUsageJPA extends DAOBaseClassJPA<Usages> implements DAOUsage {

	public DAOUsageJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Usages> findAll() {
		TypedQuery<Usages> query = entityManager.createNamedQuery("Usage.findAll", Usages.class);
		return query.getResultList();
	}

	@Override
	public Usages getById(int id) {
		TypedQuery<Usages> query = entityManager.createNamedQuery("Usage.findById", Usages.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
