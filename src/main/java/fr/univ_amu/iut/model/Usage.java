package fr.univ_amu.iut.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Usage.findAll", query = "SELECT p FROM Usage p"),
        @NamedQuery(name = "Usage.findById", query = "SELECT p FROM Usage p WHERE p.id = :id"),
        @NamedQuery(name = "Usage.findByNamePart", query = "SELECT p FROM Usage p WHERE LOWER(p.nom) LIKE :substring"),
        @NamedQuery(name = "Usage.findByCriterias", query = "SELECT p FROM Usage p WHERE" +
                "(:thematique is null or :thematique=p.thematique)" +
                "AND (:discipline is null or :discipline=p.discipline)"+
                "AND (:academie is null or :academie=p.academie)"),
})

@Entity
@Table(name="\"USAGE\"")
public class Usage implements Serializable {
    @Id
    @GeneratedValue
    int id;

    String nom;

    String description;

    @ManyToOne(cascade = CascadeType.ALL)
    Discipline discipline;

    @ManyToOne(cascade = CascadeType.ALL)
    Thematique thematique;

    @Enumerated(EnumType.STRING)
    Niveau niveau;

    @OneToOne(cascade = CascadeType.ALL)
    Academie academie;

    @OneToMany(cascade = CascadeType.ALL)
    List<Ressource> ressources = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    List<Acteur> acteurs = new ArrayList<>();

    String commentaire;

    public Usage() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Thematique getThematique() {
        return thematique;
    }

    public void setThematique(Thematique thematique) {
        this.thematique = thematique;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Academie getAcademie() {
        return academie;
    }

    public void setAcademie(Academie academie) {
        this.academie = academie;
    }

    public List<Ressource> getRessources() {
        return ressources;
    }

    public void addRessource(Ressource ressource) {
        this.ressources.add(ressource);
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void addActeur(Acteur acteur) {
        this.acteurs.add(acteur);
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }


    @Override
    public String toString() {
        return "Usage{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", discipline=" + discipline +
                ", thematique=" + thematique +
                ", niveau=" + niveau +
                ", academie=" + academie +
                ", ressources=" + ressources +
                ", acteurs=" + acteurs +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usage usage = (Usage) o;

        return id == usage.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
