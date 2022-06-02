package fr.univ_amu.iut.model;

import jakarta.persistence.*;

@NamedQueries({
		@NamedQuery(name = "TypeActeur.findAll", query = "SELECT p FROM TypeActeur p"),
		@NamedQuery(name = "TypeActeur.findById", query = "SELECT p FROM TypeActeur p WHERE p.id = :id"),
})
@Entity
public class TypeActeur {
	@Id
	@GeneratedValue
	int id;
	String nom;

	public TypeActeur(String nom) {
		this.nom = nom;
	}

	public TypeActeur() {

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
