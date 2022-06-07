package fr.univ_amu.iut.dao.factory;

public enum DAOType {
    JPA,
    JPA_MEMORY, // JPA, mais sans persistence (base de données en mémoire) (utilisé pour le test de JPA)
    TEST // utilisé pour le test de l'interface graphique
}
