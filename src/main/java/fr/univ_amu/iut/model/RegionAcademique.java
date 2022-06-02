package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class RegionAcademique {

    private static List<RegionAcademique> INSTANCES = new ArrayList<>();

    @Transient
    public static RegionAcademique AuvergneRhoneAlpes = new RegionAcademique("Région académique Auvergne-Rhône-Alpes");
    @Transient
    public static RegionAcademique BourgogneFrancheComte = new RegionAcademique("Région académique Bourgogne-Franche-Comté");
    @Transient
    public static RegionAcademique Bretagne = new RegionAcademique("Région académique Bretagne");
    @Transient
    public static RegionAcademique CentreValDeLoire = new RegionAcademique("Région académique Centre-Val de Loire");
    @Transient
    public static RegionAcademique Corse = new RegionAcademique("Région académique Corse");
    @Transient
    public static RegionAcademique GrandEst = new RegionAcademique("Région académique Grand Est");
    @Transient
    public static RegionAcademique Guadeloupe = new RegionAcademique("Région académique Guadeloupe");
    @Transient
    public static RegionAcademique Guyane = new RegionAcademique("Région académique Guyane");
    @Transient
    public static RegionAcademique HautsDeFrance = new RegionAcademique("Région académique Hauts-de-France");
    @Transient
    public static RegionAcademique IleDeFrance = new RegionAcademique("Région académique Île-de-France");
    @Transient
    public static RegionAcademique Martinique = new RegionAcademique("Région académique Martinique");
    @Transient
    public static RegionAcademique Normandie = new RegionAcademique("Région académique Normandie");
    @Transient
    public static RegionAcademique NouvelleAquitaine = new RegionAcademique("Région académique Nouvelle-Aquitaine");
    @Transient
    public static RegionAcademique Occitanie = new RegionAcademique("Région académique Occitanie");
    @Transient
    public static RegionAcademique PaysDeLaLoire = new RegionAcademique("Région académique Pays de la Loire");
    @Transient
    public static RegionAcademique ProvenceAlpesCoteDAzur = new RegionAcademique("Région académique Provence-Alpes-Côte d'Azur");
    @Transient
    public static RegionAcademique Reunion = new RegionAcademique("Région académique La Réunion");
    @Transient
    public static RegionAcademique Mayotte = new RegionAcademique("Région académique Mayotte");

    @Id
    @GeneratedValue
    int id;
    String nom;

    public RegionAcademique() {
        INSTANCES.add(this);
    }
    public RegionAcademique(String nom) {
        this();
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
}
