package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.model.Discipline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAODisciplineJPA extends DAOBaseClassJPA<Discipline> implements DAODiscipline {

	public DAODisciplineJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Discipline> findAll() {
		TypedQuery<Discipline> query = entityManager.createNamedQuery("Discipline.findAll", Discipline.class);
		return query.getResultList();
	}

	@Override
	public Discipline getById(int id) {
		TypedQuery<Discipline> query = entityManager.createNamedQuery("Discipline.findById", Discipline.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
