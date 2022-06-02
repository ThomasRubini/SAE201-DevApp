package fr.univ_amu.iut.fResultat;

import java.util.List;

public class Utilisateur {

    private int Numéro ;
    private String Noms;
    private String Disciplines;
    private String Types;
    private String Niveaux;

    public Utilisateur(int numero, String noms, String disciplines, String types, String niveaux) {
        Numéro = numero;
        Noms = noms;
        Disciplines = disciplines;
        Types = types;
        Niveaux = niveaux;
    }

    public int getNuméro() {
        return Numéro;
    }

    public String getNoms() {
        return Noms;
    }

    public String getDisciplines() {
        return Disciplines;
    }

    public String getTypes() {
        return Types;
    }

    public String getNiveaux() {
        return Niveaux;
    }
}
