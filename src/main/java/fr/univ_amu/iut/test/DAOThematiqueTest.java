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
            URL url = null;
            try {
                url = new URL("http://google.com");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Thematique thematique = new Thematique(String.valueOf(i));
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