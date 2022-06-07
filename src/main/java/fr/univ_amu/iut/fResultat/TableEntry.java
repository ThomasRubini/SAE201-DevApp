package fr.univ_amu.iut.fResultat;

import java.util.List;

import fr.univ_amu.iut.model.Usage;

public class TableEntry {

    private String nom;
    private String discipline;
    private String description;
    private String niveau;

    public TableEntry(Usage usage) {
        nom = usage.getNom();
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


}
