package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Acteur.findAll", query = "SELECT p FROM Acteur p"),
        @NamedQuery(name = "Acteur.findById", query = "SELECT p FROM Acteur p WHERE p.id = :id"),
})
@Entity
public class Acteur {
    @Id
    @GeneratedValue
    int id;

    String identite;

    String type;

    public Acteur(String identite, String type) {
        this.type = type;
        this.identite = identite;
    }

    public Acteur() {
    }

    public int getId() {
        return id;
    }

    public String getIdentite() {
        return identite;
    }

    public String getType() {
        return type;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public void setType(String typeActeur) {
        this.type = typeActeur;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", identite='" + identite + '\'' +
                '}';
    }
}
