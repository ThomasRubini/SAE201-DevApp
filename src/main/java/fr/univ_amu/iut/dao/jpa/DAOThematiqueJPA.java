package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.model.Thematique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAOThematiqueJPA extends DAOBaseClassJPA<Thematique> implements DAOThematique {

	public DAOThematiqueJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Thematique> findAll() {
		TypedQuery<Thematique> query = entityManager.createNamedQuery("Thematique.findAll", Thematique.class);
		return query.getResultList();
	}

	@Override
	public Thematique getById(int id) {
		TypedQuery<Thematique> query = entityManager.createNamedQuery("Thematique.findById", Thematique.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
