package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.net.MalformedURLException;
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

    URL lienRessource;

    String typeRessource;

    private static URL convertUrl(String url){
        try{
            return new URL(url);
        }catch(MalformedURLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Ressource(String nomRessource, String lienRessource, String typeRessource) {
        this(nomRessource, convertUrl(lienRessource), typeRessource);
    }
    public Ressource(String nomRessource, URL lienRessource, String typeRessource) {
        this.nomRessource = nomRessource;
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
