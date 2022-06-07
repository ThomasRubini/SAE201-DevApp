package fr.univ_amu.iut.dao.test;

import java.util.ArrayList;
import java.util.List;

import fr.univ_amu.iut.dao.DAOUsage;
import fr.univ_amu.iut.model.Academie;
import fr.univ_amu.iut.model.Discipline;
import fr.univ_amu.iut.model.Niveau;
import fr.univ_amu.iut.model.Thematique;
import fr.univ_amu.iut.model.Usage;

public class DAOUsageTest implements DAOUsage{

    @Override
    public boolean delete(Usage obj) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Usage> findAll() {
        List<Usage> usages = new ArrayList<>();
        for( int i = 0; i < 42 ; i++){
            Usage tmp = new Usage();
            tmp.setNom("Usage n°"+ i);
            tmp.setDiscipline(Discipline.Technologie);
            tmp.setThematique(Thematique.CreationNumerique);
            tmp.setNiveau(Niveau.Tous);
            tmp.setDescription("je suis un commentaire tres long mais surtout tres utile, je sert a tester l'interface graphique et la mettre au bout de ses limites");
            usages.add(tmp);
        }

        Usage tmp = new Usage();
        tmp.setNom("Usage spécial 1");
        tmp.setDiscipline(Discipline.PhysiqueChimie);
        tmp.setThematique(Thematique.ClasseInversee);
        tmp.setNiveau(Niveau.PremierDegre);
        tmp.setDescription("Un usage très simple, pour un test de recherche");
        usages.add(tmp);

        return usages;
    }

    @Override
    public Usage getById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(Usage obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(Usage obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Usage> findByCriterias(Thematique thematique, Discipline discipline, Academie academie) {
        List<Usage> list = new ArrayList<>();
        for(Usage usage : findAll()){
            if((thematique==null||thematique==usage.getThematique())&&
                    (discipline==null||discipline==usage.getDiscipline())&&
                    (academie==null||academie==usage.getAcademie())){
                list.add(usage);
            }
        }
        return list;
    }

    @Override
    public List<Usage> findByNamePart(String substring) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
