package fr.univ_amu.iut.dao.jpa.trans;

import fr.univ_amu.iut.dao.DAOAcademie;
import fr.univ_amu.iut.model.Academie;

import java.util.ArrayList;
import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAOAcademieTransient implements DAOAcademie {

	public DAOAcademieTransient() {

	}

	@Override
	public boolean delete(Academie obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean insert(Academie obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(Academie obj) {
		throw new UnsupportedOperationException();
	}



	@Override
	public List<Academie> findAll() {
		// TODO maybe make the method return a Collection instead
		return new ArrayList<>(Academie.toutes());
	}

	@Override
	public Academie getById(int id) {
		throw new UnsupportedOperationException("Les academies disposent de codes. Utilisez Academie#getByCode");
	}

	@Override
	public Academie getByCode(String code) {
		return Academie.get(code);
	}
}
