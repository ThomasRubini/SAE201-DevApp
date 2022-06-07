package fr.univ_amu.iut.test;

import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.model.Ressource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DAORessourceTest implements DAORessource {
    @Override
    public boolean delete(Ressource obj) {
        return false;
    }

    @Override
    public List<Ressource> findAll() {
        List<Ressource> liste = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            Ressource ressource = new Ressource("google", "http://google.com", "site web");
            liste.add(ressource);
        }
        return liste;
    }

    @Override
    public Ressource getById(int id) {
        return null;
    }

    @Override
    public boolean insert(Ressource obj) {
        return false;
    }

    @Override
    public boolean update(Ressource obj) {
        return false;
    }
}