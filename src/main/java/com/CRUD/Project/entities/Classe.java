package com.CRUD.Project.entities;

public class Classe {
	private long id ;
	private String nom ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Classe(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	public Classe() {
		super();
	}
}
