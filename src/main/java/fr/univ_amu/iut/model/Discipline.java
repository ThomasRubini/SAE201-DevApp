package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Discipline.findAll", query = "SELECT p FROM Discipline p"),
        @NamedQuery(name = "Discipline.findById", query = "SELECT p FROM Discipline p WHERE p.id = :id"),
})
@Entity
public class Discipline implements Serializable {

    private static final List<Discipline> INSTANCES = new ArrayList<>();

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
    @Transient
    public static Discipline Mathematiques = new Discipline("Mathématiques");
    @Transient
    public static Discipline Philosophie = new Discipline("Philosophie");
    @Id
    @GeneratedValue
    int id;

    @Column(unique = true)
    String nom;

    public Discipline() {
    }

    public Discipline(String nom) {
        this.nom = nom;
        INSTANCES.add(this);
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


    @Override
    public String toString() {
        return "Discipline{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

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
