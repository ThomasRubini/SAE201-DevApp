package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "RegionAcademique.findAll", query = "SELECT p FROM RegionAcademique p"),
        @NamedQuery(name = "RegionAcademique.findById", query = "SELECT p FROM RegionAcademique p WHERE p.id = :id"),
})
@Entity
public class RegionAcademique implements Serializable {

    private static List<RegionAcademique> INSTANCES = new ArrayList<>();

    public static RegionAcademique AuvergneRhoneAlpes = new RegionAcademique("Région académique Auvergne-Rhône-Alpes");

    public static RegionAcademique BourgogneFrancheComte = new RegionAcademique("Région académique Bourgogne-Franche-Comté");

    public static RegionAcademique Bretagne = new RegionAcademique("Région académique Bretagne");

    public static RegionAcademique CentreValDeLoire = new RegionAcademique("Région académique Centre-Val de Loire");

    public static RegionAcademique Corse = new RegionAcademique("Région académique Corse");

    public static RegionAcademique GrandEst = new RegionAcademique("Région académique Grand Est");

    public static RegionAcademique Guadeloupe = new RegionAcademique("Région académique Guadeloupe");

    public static RegionAcademique Guyane = new RegionAcademique("Région académique Guyane");

    public static RegionAcademique HautsDeFrance = new RegionAcademique("Région académique Hauts-de-France");

    public static RegionAcademique IleDeFrance = new RegionAcademique("Région académique Île-de-France");

    public static RegionAcademique Martinique = new RegionAcademique("Région académique Martinique");

    public static RegionAcademique Normandie = new RegionAcademique("Région académique Normandie");

    public static RegionAcademique NouvelleAquitaine = new RegionAcademique("Région académique Nouvelle-Aquitaine");

    public static RegionAcademique Occitanie = new RegionAcademique("Région académique Occitanie");

    public static RegionAcademique PaysDeLaLoire = new RegionAcademique("Région académique Pays de la Loire");

    public static RegionAcademique ProvenceAlpesCoteDAzur = new RegionAcademique("Région académique Provence-Alpes-Côte d'Azur");

    public static RegionAcademique Reunion = new RegionAcademique("Région académique La Réunion");

    public static RegionAcademique Mayotte = new RegionAcademique("Région académique Mayotte");


    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    String nom;

    public RegionAcademique() {

    }

    public RegionAcademique(String nom) {
        INSTANCES.add(this);
        this.nom = nom;
    }

    public static List<RegionAcademique> toutes(){
        return INSTANCES;
    }

    public static RegionAcademique getById(int id){
        for(RegionAcademique regionAcademique : INSTANCES){
            if(regionAcademique.id == id)return regionAcademique;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }


    @Override
    public String toString() {
        return "RegionAcademique{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionAcademique that = (RegionAcademique) o;

        if (id != that.id) return false;
        return nom.equals(that.nom);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nom.hashCode();
        return result;
    }
}
