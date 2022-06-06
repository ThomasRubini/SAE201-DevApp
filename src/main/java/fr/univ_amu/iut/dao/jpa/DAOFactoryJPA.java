package fr.univ_amu.iut.dao.jpa;

import fr.univ_amu.iut.dao.*;
import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.RegionAcademique;
import fr.univ_amu.iut.model.Thematique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Collection;

public class DAOFactoryJPA implements DAOFactory {

    private EntityManager entityManager;


    // Pas sûr de ou initialiser la base de données
    /*
     On part du principe que les données dans la base de données sont inconnues :
     certaines données peuvent être insérées et d'autres non. Nous faisons attention aux erreurs
     Nous essayons d'être persistents aux erreurs
     */


    private <T> void insertAllHelper(DAO<T> dao, Collection<T> list){
        if(dao.findAll().size()==0){
            entityManager.getTransaction().begin();
            list.forEach(obj -> entityManager.persist(obj));
            entityManager.getTransaction().commit();
        }
    }

    public DAOFactoryJPA(){

        insertAllHelper(createDAORegionAcademique(), RegionAcademique.toutes());
        insertAllHelper(createDAOAcademie(), Academie.toutes());
        insertAllHelper(createDAOThematique(), Thematique.toutes());
        insertAllHelper(createDAODiscipline(), Discipline.toutes());
    }

    public EntityManager getEntityManager() {
        if(entityManager == null){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestionUsagesPU");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    @Override
    public DAOAcademie createDAOAcademie() {
        return new DAOAcademieJPA(getEntityManager());
    }

    @Override
    public DAOActeur createDAOActeur() {
        return new DAOActeurJPA(getEntityManager());
    }

    @Override
    public DAODiscipline createDAODiscipline() {
        return new DAODisciplineJPA(getEntityManager());
    }

    @Override
    public DAORegionAcademique createDAORegionAcademique() {
        return new DAORegionAcademiqueJPA(getEntityManager());
    }

    @Override
    public DAORessource createDAORessource() {
        return new DAORessourceJPA(getEntityManager());
    }

    @Override
    public DAOThematique createDAOThematique() {
        return new DAOThematiqueJPA(getEntityManager());
    }


    @Override
    public DAOUsage createDAOUsage() {
        return new DAOUsageJPA(getEntityManager());
    }
}
