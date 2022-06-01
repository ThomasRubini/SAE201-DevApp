package fr.univ_amu.iut.dao.jpa.trans;

import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.model.Discipline;

import java.util.ArrayList;
import java.util.List;

// NOT JPA. No idea how to achieve it else
public class DAODisciplineTransient implements DAODiscipline {

	public DAODisciplineTransient() {

	}

	@Override
	public boolean delete(Discipline obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean insert(Discipline obj) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(Discipline obj) {
		throw new UnsupportedOperationException();
	}



	@Override
	public List<Discipline> findAll() {
		// TODO maybe make the method return a Collection instead
		return Discipline.toutes();
	}

	@Override
	public Discipline getById(int id) {
		return Discipline.getById(id);
	}
}
