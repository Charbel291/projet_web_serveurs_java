package com.octest.beans;

public class RendezVous {
	private String medecin;
	private String patient;
	private String session;
	
	public String getMedecin() {
		return medecin;
	}

	public void setMedecin(String medecin) {
		this.medecin = medecin;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof RendezVous) {
			RendezVous rdv = (RendezVous) obj;
			String medecin = rdv.getMedecin();
			String patient = rdv.getPatient();
			String session = rdv.getSession();
			if(this.medecin.equals(medecin)&&this.patient.equals(patient)&&this.session.equals(session)){
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
		return "rdv ("+medecin.toString()+", "+patient.toString()+", "+session+")";
	}
}
