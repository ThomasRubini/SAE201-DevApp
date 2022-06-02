package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.net.URL;

@NamedQueries({
        @NamedQuery(name = "Ressource.findAll", query = "SELECT p FROM Ressource p"),
        @NamedQuery(name = "Ressource.findById", query = "SELECT p FROM Ressource p WHERE p.id = :id"),
})
@Entity
public class Ressource {
    @Id
    @GeneratedValue
    int id;

    String nomRessource;

    String typeRessource;
    URL lienRessource;

    public Ressource(URL lienRessource, String nomRessource, String typeRessource) {
        this.typeRessource = typeRessource;
        this.lienRessource = lienRessource;
    }

    public Ressource() {

    }

    public String getTypeRessource() {
        return typeRessource;
    }

    public URL getLienRessource() {
        return lienRessource;
    }

    public String getNomRessource() {
        return nomRessource;
    }


    @Override
    public String toString() {
        return "Ressource{" +
                "id=" + id +
                ", nomRessource='" + nomRessource + '\'' +
                ", typeRessource='" + typeRessource + '\'' +
                ", lienRessource=" + lienRessource +
                '}';
    }
}
