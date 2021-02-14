package com.octest.beans;

public class Patient {
	private String email;
	private String nom;
	private String prenom;
	private String numero_tel;
	private String adresse;
	private String annee_naissance;
	private String password;
	
	public Patient(String email, String nom, String prenom, String numero_tel, String adresse, String annee_naissance, String password) {
		this.email=email;
		this.nom=nom;
		this.prenom=prenom;
		this.numero_tel=numero_tel;
		this.adresse = adresse;
		this.annee_naissance=annee_naissance;
		this.password=password;
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

	public String getAnnee_naissance() {
		return annee_naissance;
	}

	public void setAnnee_naissance(String annee_naissance) {
		this.annee_naissance = annee_naissance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Patient) {
			Patient patient = (Patient) obj;
			String email = patient.getEmail();
			if(this.email.equals(email)){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return email+" "+prenom+" "+nom;
	}
	
}
