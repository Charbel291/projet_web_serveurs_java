package com.octest.beans;

public class Client {
	private String email;
	private String nom;
	private String prenom;
	private String adresse;
	private String numero_tel;
	private String password;
	private String annee_naissance;
	
	public String getAnnee_naissance() {
		return annee_naissance;
	}

	public void setAnnee_naissance(String annee_naissance) {
		this.annee_naissance = annee_naissance;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getNumero_tel() {
		return numero_tel;
	}
	
	public void setNumero_tel(String numero_tel) {
		this.numero_tel = numero_tel;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
