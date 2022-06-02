package fr.univ_amu.iut.test;

import fr.univ_amu.iut.dao.DAOAcademie;
import fr.univ_amu.iut.model.Academie;
import java.util.List;

public class DAOAcademieTest implements DAOAcademie {
    @Override
    public boolean delete(Academie obj) {
        return false;
    }

    @Override
    public List<Academie> findAll() {
        return null;
    }

    @Override
    public Academie getById(int id) {
        return null;
    }

    @Override
    public boolean insert(Academie obj) {
        return false;
    }

    @Override
    public boolean update(Academie obj) {
        return false;
    }

    @Override
    public Academie getByCode(String code) {
        return null;
    }
}