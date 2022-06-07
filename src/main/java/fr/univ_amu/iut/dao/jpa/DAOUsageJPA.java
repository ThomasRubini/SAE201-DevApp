package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.Usage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

	@Override
	public List<Usage> findByCriterias(Thematique thematique, Discipline discipline, Academie academie) {
		TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByCriterias", Usage.class);
		query.setParameter("thematique", thematique);
		query.setParameter("discipline", discipline);
		query.setParameter("academie", academie);
		return query.getResultList();
	}


	@Override
	public List<Usage> findByNamePart(String substring) {
		TypedQuery<Usage> query = entityManager.createNamedQuery("Usage.findByNamePart", Usage.class);
		query.setParameter("substring", "%"+substring.toLowerCase()+"%");
		return query.getResultList();
	}
}
