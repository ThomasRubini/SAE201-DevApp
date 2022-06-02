package fr.univ_amu.iut.test;

import fr.univ_amu.iut.dao.DAODiscipline;
import fr.univ_amu.iut.model.Discipline;
import java.util.List;

public class DAODisciplineTest implements DAODiscipline {
    @Override
    public boolean delete(Discipline obj) {
        return false;
    }

    @Override
    public List<Discipline> findAll() {
        return null;
    }

    @Override
    public Discipline getById(int id) {
        return null;
    }

    @Override
    public boolean insert(Discipline obj) {
        return false;
    }

    @Override
    public boolean update(Discipline obj) {
        return false;
    }
}