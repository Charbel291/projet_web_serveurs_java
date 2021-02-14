package com.octest.beans;

public class Annuaire {
	private String centre_medical;
	private String medecin_email;
	private String specialite;
	
	public Annuaire(String centre_medical, String medecin_email, String specialite) {
		this.centre_medical=centre_medical;
		this.medecin_email=medecin_email;
		this.specialite=specialite;
	}
	
	public String getCentre_medical() {
		return centre_medical;
	}
	
	public void setCentre_medical(String centre_medical) {
		this.centre_medical = centre_medical;
	}
	
	public String getMedecin() {
		return medecin_email;
	}
	
	public void setMedecin(String medecin_email) {
		this.medecin_email = medecin_email;
	}
	
	public String getSpecialite() {
		return specialite;
	}
	
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Annuaire) {
			Annuaire annuaire = (Annuaire) obj;
			String medecin_email = annuaire.getMedecin();
			String centre_medical = annuaire.getCentre_medical();
			if(this.medecin_email.equals(medecin_email)&&this.centre_medical.equals(centre_medical)){
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
		return medecin_email+", "+specialite+", "+centre_medical;
	}
}
