package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.DAORegionAcademique;
import fr.univ_amu.iut.model.RegionAcademique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAORegionAcademiqueJPA extends DAOBaseClassJPA<RegionAcademique> implements DAORegionAcademique {

	public DAORegionAcademiqueJPA(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<RegionAcademique> findAll() {
		TypedQuery<RegionAcademique> query = entityManager.createNamedQuery("RegionAcademique.findAll", RegionAcademique.class);
		return query.getResultList();
	}

	@Override
	public RegionAcademique getById(int id) {
		TypedQuery<RegionAcademique> query = entityManager.createNamedQuery("RegionAcademique.findById", RegionAcademique.class);
		query.setParameter("numEt", id);
		return query.getSingleResult();
	}
}
