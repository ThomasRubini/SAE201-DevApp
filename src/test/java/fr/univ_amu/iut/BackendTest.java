package fr.univ_amu.iut;

import fr.univ_amu.iut.dao.factory.DAOFactory;
import fr.univ_amu.iut.dao.jpa.DAOFactoryJPA;
import fr.univ_amu.iut.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class BackendTest {

	private static DAOFactoryJPA daoFactory;

	@BeforeAll
	public static void setUp() throws Exception {
		daoFactory = new DAOFactoryJPA("gestionUsagesPUTest");

		Usage usage = new Usage();
		usage.setNom("Nom d'usage n°1");
		usage.addActeur(new Acteur("Thomas", "Developpeur"));
		usage.addActeur(new Acteur("Djalim", "Developpeur"));
		usage.addRessource(new Ressource("Google", "https://google.com", "Site web"));
		usage.setDiscipline(new Discipline("Informatique"));

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
		// on ne créé pas une fonction findByName car elle ne serait utilisée que pour le test

		boolean ecoleInclusiveFound = false;
		for(Thematique thematique : daoFactory.createDAOThematique().findAll()) {
			if (thematique.getNom().equals("École inclusive")) {
				ecoleInclusiveFound = true;
				break;
			}
		}
		assertThat(ecoleInclusiveFound).isTrue();
	}
}