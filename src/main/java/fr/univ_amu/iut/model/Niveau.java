package fr.univ_amu.iut.model;

public enum Niveau {
    Tous("Tous niveaux"),
    PremierDegre("Premier degré"),
    SecondDegre("Second degré");
    final String nom;
    Niveau(String nom){
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public static Niveau getByNom(String nom) {
        for(Niveau niv : values()){
            if(niv.nom.equals(nom))return niv;
        }
        return null;
    }


    @Override
    public String toString() {
        return "Niveau{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
