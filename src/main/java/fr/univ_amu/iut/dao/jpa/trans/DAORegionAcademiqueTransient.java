package fr.univ_amu.iut.dao.jpa.trans;

import fr.univ_amu.iut.dao.DAORegionAcademique;
import fr.univ_amu.iut.model.RegionAcademique;

import java.util.ArrayList;
import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAORegionAcademiqueTransient implements DAORegionAcademique {

	public DAORegionAcademiqueTransient() {

	}

	@Override
	public boolean delete(RegionAcademique obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean insert(RegionAcademique obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(RegionAcademique obj) {
		throw new UnsupportedOperationException();
	}



	@Override
	public List<RegionAcademique> findAll() {
		// TODO maybe make the method return a Collection instead
		return new ArrayList<>(RegionAcademique.toutes());
	}

	@Override
	public RegionAcademique getById(int id) {
		throw new UnsupportedOperationException("Les RegionAcademiques disposent de codes. Utilisez RegionAcademique#getByCode");
	}
}
