package com.octest.beans;

public class RendezVous {
	private String medecin_email;
	private String patient_email;
	private String session;
	
	public RendezVous(String medecin_email, String patient_email, String session) {
		this.medecin_email=medecin_email;
		this.patient_email=patient_email;
		this.session=session;
	}
	
	public String getMedecin() {
		return medecin_email;
	}

	public void setMedecin(String medecin_email) {
		this.medecin_email = medecin_email;
	}

	public String getPatient() {
		return patient_email;
	}

	public void setPatient(String patient_email) {
		this.patient_email = patient_email;
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
			if(this.medecin_email.equals(medecin)&&this.patient_email.equals(patient)&&this.session.equals(session)){
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
		return "rdv ("+medecin_email.toString()+", "+patient_email.toString()+", "+session+")";
	}
	
	
}
