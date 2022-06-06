package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "Acteur.findAll", query = "SELECT p FROM Acteur p"),
        @NamedQuery(name = "Acteur.findById", query = "SELECT p FROM Acteur p WHERE p.id = :id"),
})
@Entity
public class Acteur implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Acteur acteur = (Acteur) o;

        if (id != acteur.id) return false;
        if (!identite.equals(acteur.identite)) return false;
        return type.equals(acteur.type);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + identite.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
