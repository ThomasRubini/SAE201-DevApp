package fr.univ_amu.iut;

import fr.univ_amu.iut.dao.DAORessource;
import fr.univ_amu.iut.model.Ressource;
import fr.univ_amu.iut.model.TypeRessource;

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
    public List<Ressource> findAll() throws MalformedURLException {
        List<Ressource> liste = new ArrayList<>();
        for (int i = 0; i < 12; i++){
            TypeRessource type = new TypeRessource(String.valueOf(i));
            URL url = new URL("http://google.com");
            Ressource ressource = new Ressource(type,url);
            liste.add(ressource);
        }
        return liste;
    }

    @Override
    public Ressource getById(int id) {
        return null;
    }

    @Override
    public Ressource insert(Ressource obj) {
        return null;
    }

    @Override
    public boolean update(Ressource obj) {
        return false;
    }
}