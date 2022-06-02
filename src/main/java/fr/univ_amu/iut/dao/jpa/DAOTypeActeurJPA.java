package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAO;
import fr.univ_amu.iut.model.TypeActeur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DAOTypeActeurJPA extends DAOBaseClassJPA<TypeActeur> implements DAO<TypeActeur> {

	public DAOTypeActeurJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<TypeActeur> findAll() {
		TypedQuery<TypeActeur> query = entityManager.createNamedQuery("TypeActeur.findAll", TypeActeur.class);
		return query.getResultList();
	}

	@Override
	public TypeActeur getById(int id) {
		TypedQuery<TypeActeur> query = entityManager.createNamedQuery("TypeActeur.findById", TypeActeur.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
