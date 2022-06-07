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

    
    public static Discipline Toutes = new Discipline("Toutes disciplines");
    
    public static Discipline HistoireGeographie = new Discipline("Histoire-géographie");
    
    public static Discipline PhysiqueChimie = new Discipline("Physique-chimie");
    
    public static Discipline ScienceEtVieDeLaTerre = new Discipline("SVT");
    
    public static Discipline Technologie = new Discipline("Technologie");
    
    public static Discipline Francais = new Discipline("Français");
    
    public static Discipline EconomieGestion = new Discipline("Économie Gestion");
    
    public static Discipline LangueVivante = new Discipline("Langue Vivante");

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
