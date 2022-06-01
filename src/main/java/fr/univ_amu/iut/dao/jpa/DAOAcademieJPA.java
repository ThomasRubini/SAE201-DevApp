package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOAcademie;
import fr.univ_amu.iut.model.Academie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAOAcademieJPA extends DAOBaseClassJPA<Academie> implements DAOAcademie {

	public DAOAcademieJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Academie> findAll() {
		TypedQuery<Academie> query = entityManager.createNamedQuery("Academie.findAll", Academie.class);
		return query.getResultList();
	}

	@Override
	public Academie getById(int id) {
		throw new UnsupportedOperationException("use getByCode()");
	}

	@Override
	public Academie getByCode(String code) {
		TypedQuery<Academie> query = entityManager.createNamedQuery("Academie.findByCode", Academie.class);
		query.setParameter("acaCode", code);
		return query.getSingleResult();
	}
}
