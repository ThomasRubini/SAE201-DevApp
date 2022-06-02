package fr.univ_amu.iut.test;

import fr.univ_amu.iut.dao.*;
import fr.univ_amu.iut.dao.factory.DAOFactory;

public class DAOFactoryTest implements DAOFactory {

    @Override
    public DAOAcademie createDAOAcademie() {
        return null;
    }

    @Override
    public DAOActeur createDAOActeur() {
        return null;
    }

    @Override
    public DAODiscipline createDAODiscipline() {
        return null;
    }

    @Override
    public DAORegionAcademique createDAORegionAcademique() {
        return null;
    }

    @Override
    public DAORessource createDAORessource() {
        return new DAORessourceTest();
    }

    @Override
    public DAOThematique createDAOThematique() {
        return new DAOThematiqueTest();
    }

    @Override
    public DAOUsage createDAOUsage() {
        return null;
    }
}
