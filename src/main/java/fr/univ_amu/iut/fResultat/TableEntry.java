package fr.univ_amu.iut.fResultat;

import java.util.List;

import fr.univ_amu.iut.model.Usage;

public class TableEntry {

    private String nom;
    private String discipline;
    private String thematique;
    private String description;
    private String niveau;

    public TableEntry(Usage usage) {
        nom = usage.getNom();
        thematique = usage.getThematique().getNom();
        discipline = usage.getDiscipline().getNom();
        description = usage.getDescription();
        niveau = usage.getNiveau().getNom();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }


    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableEntry that = (TableEntry) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (discipline != null ? !discipline.equals(that.discipline) : that.discipline != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return niveau != null ? niveau.equals(that.niveau) : that.niveau == null;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (niveau != null ? niveau.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "TableEntry{" +
                "nom='" + nom + '\'' +
                ", discipline='" + discipline + '\'' +
                ", description='" + description + '\'' +
                ", niveau='" + niveau + '\'' +
                '}';
    }
}
