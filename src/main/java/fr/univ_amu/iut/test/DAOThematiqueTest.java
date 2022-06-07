package fr.univ_amu.iut.test;

import fr.univ_amu.iut.dao.DAOThematique;
import fr.univ_amu.iut.model.Thematique;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DAOThematiqueTest implements DAOThematique {
    @Override
    public boolean delete(Thematique obj) {
        return false;
    }

    @Override
    public List<Thematique> findAll() {
        List<Thematique> liste = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            Thematique thematique = new Thematique("Thematique n° "+i);
            liste.add(thematique);
        }
        return liste;
    }

    @Override
    public Thematique getById(int id) {
        return null;
    }

    @Override
    public boolean insert(Thematique obj) {
        return false;
    }

    @Override
    public boolean update(Thematique obj) {
        return false;
    }
}