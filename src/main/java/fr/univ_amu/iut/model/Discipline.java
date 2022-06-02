package fr.univ_amu.iut.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Discipline {

    private static List<Discipline> INSTANCES = new ArrayList<>();

    @Transient
    public static Discipline Toutes = new Discipline("Toutes disciplines");
    @Transient
    public static Discipline HistoireGeographie = new Discipline("Histoire-géographie");
    @Transient
    public static Discipline PhysiqueChimie = new Discipline("Physique-chimie");
    @Transient
    public static Discipline ScienceEtVieDeLaTerre = new Discipline("SVT");
    @Transient
    public static Discipline Technologie = new Discipline("Technologie");
    @Transient
    public static Discipline Francais = new Discipline("Français");
    @Transient
    public static Discipline EconomieGestion = new Discipline("Économie Gestion");
    @Transient
    public static Discipline LangueVivante = new Discipline("Langue Vivante");

    @Id
    @GeneratedValue
    int id;
    String nom;

    public Discipline() {
        INSTANCES.add(this);
    }

    Discipline(String nom) {
        this();
        this.nom = nom;
    }

    public static List<Discipline> toutes() {
        return INSTANCES;
    }

    public static Discipline getById(int id){
		for(Discipline discipline : Discipline.toutes()) {
            if (discipline.id == id) return discipline;
        }
        return null;
    }

    public int getId(){
        return id;
    }

    public String getNom() {
        return nom;
    }
}
