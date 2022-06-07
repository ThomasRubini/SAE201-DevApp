package fr.univ_amu.iut;

import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.dao.factory.DAOFactoryProducer;
import fr.univ_amu.iut.dao.factory.DAOType;
import fr.univ_amu.iut.dao.jpa.DAOFactoryJPA;
import fr.univ_amu.iut.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BackendTest {

	private static DAOFactory daoFactory;

	@BeforeAll
	public static void setUp() throws Exception {
		daoFactory = DAOFactoryProducer.getFactory(DAOType.JPA_MEMORY);

		Usage usage = new Usage();
		usage.setNom("Premier usage");
		usage.addActeur(new Acteur("Thomas", "Developpeur back-end"));
		usage.addActeur(new Acteur("Djalim", "Developpeur Linux"));
		usage.addRessource(new Ressource("Google", "https://google.com", "Site web"));
		usage.setDiscipline(new Discipline("Informatique"));
		usage.setThematique(Thematique.ExpressionOrale);
		usage.setDiscipline(Discipline.Francais);

		daoFactory.createDAOUsage().insert(usage);

		usage = new Usage();
		usage.setNom("Second usage");
		usage.addActeur(new Acteur("Lucas", "Hacker professionnel"));
		usage.addRessource(new Ressource("Google", "https://google.com", "Site web"));
		usage.addRessource(new Ressource("Stackoverflow", "http://stackoverflow.com", "Site web"));
		usage.setDiscipline(Discipline.Francais);
		usage.setThematique(Thematique.ClasseInversee);

		daoFactory.createDAOUsage().insert(usage);

		usage = new Usage();
		usage.setNom("Troisieme usage");
		usage.addActeur(new Acteur("Lucas", "Beta testeur"));
		usage.setDiscipline(Discipline.PhysiqueChimie);
		usage.setThematique(Thematique.CreationNumerique);

		daoFactory.createDAOUsage().insert(usage);
	}

	@Test
	public void beforeeach_works() {
		assertThat(true).isTrue();
	}

	@Test
	public void thematiques_are_not_empty() {
		assertThat(daoFactory.createDAOThematique().findAll().size()).isNotZero();
	}

	@Test
	public void thematiques_contains_ecole_inclusive() {
		assertThat(daoFactory.createDAOThematique().findAll()).contains(Thematique.EcoleInclusive);
	}

	@Test
	public void disciplines_contains_svt() {
		assertThat(daoFactory.createDAODiscipline().findAll()).contains(Discipline.ScienceEtVieDeLaTerre);
	}

	@Test
	public void disciplines_does_not_contains_uninserted() {
		assertThat(daoFactory.createDAODiscipline().findAll()).doesNotContain(new Discipline("Bienséance"));
	}

	@Test
	public void usage_find_name_part() {
		var list = daoFactory.createDAOUsage().findByNamePart("Premier");
		assertThat(list.size()).isEqualTo(1);
		assertThat(list.get(0).getNom()).isEqualTo("Premier usage");

	}
	@Test
	public void usage_find_name_part_with_case() {
		var list = daoFactory.createDAOUsage().findByNamePart("pReMiEr");
		assertThat(list.size()).isEqualTo(1);
		assertThat(list.get(0).getNom()).isEqualTo("Premier usage");
	}

	@Test
	public void usage_find_by_thematique() {
		var list = daoFactory.createDAOUsage().findByCriterias(Thematique.ExpressionOrale, null, null);
		assertThat(list.size()).isEqualTo(1);
		assertThat(list.get(0).getNom()).isEqualTo("Premier usage");
	}

	@Test
	public void usage_find_by_discipline(){
		var list = daoFactory.createDAOUsage().findByCriterias(null, Discipline.Francais, null);
		assertThat(list.size()).isEqualTo(2);
		assertThat(list.get(0).getNom()).isEqualTo("Premier usage");
		assertThat(list.get(1).getNom()).isEqualTo("Second usage");
	}

	@Test
	public void usage_find_by_thematique_and_discipline(){
		var list = daoFactory.createDAOUsage().findByCriterias(Thematique.ClasseInversee, Discipline.Francais, null);
		assertThat(list.size()).isEqualTo(1);
		assertThat(list.get(0).getNom()).isEqualTo("Second usage");
	}

	@Test
	public void should_not_insert_again(){
		daoFactory.createDAOThematique().insert(Thematique.ExpressionOrale);
		daoFactory.createDAOThematique().insert(Thematique.ExpressionOrale);
	}
}
