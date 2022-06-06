package fr.univ_amu.iut.dao;

import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.Usage;

import java.util.List;

public interface DAOUsage extends DAO<Usage>{
	List<Usage> search(Thematique thematique, Discipline discipline, Academie academie);
}
