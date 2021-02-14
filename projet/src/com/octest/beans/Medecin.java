package com.octest.beans;

public class Medecin {
	private String email;
	private String nom;
	private String prenom;
	private String numero_tel;
	private String adresse;
	private String password;
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Medecin) {
			Medecin medecin = (Medecin) obj;
			String email = medecin.getEmail();
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
		return email+" Dr "+prenom+" "+nom+" ,";
	}
}
