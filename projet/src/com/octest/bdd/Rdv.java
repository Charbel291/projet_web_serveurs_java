package com.octest.bdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.RendezVous;

public class Rdv {
	private Connection connexion;
	
	public List<RendezVous> getRendezVous(String date, String medecin) {
		
		List<RendezVous> rdvs = new ArrayList<RendezVous>();
		
		loadDatabase();
		
		try {
			
			String date_debut=date+" 00:00:00";
			String date_fin=date+" 23:59:59";
			
			System.out.println(date);
			
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM rdv WHERE session>? AND session<? AND medecin_email=?");  
			ps.setString(1,date_debut);
			ps.setString(2,date_fin);
			ps.setString(3,medecin);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				String medecin_email = rs.getString("medecin_email");
				System.out.println(medecin_email);
				String patient_email = rs.getString("patient_email");
				System.out.println(patient_email);
				Timestamp timestamp = rs.getTimestamp("session");
				String session = timestamp.toString();
				System.out.println(session);
				
				RendezVous rdv = new RendezVous();
				
				rdv.setMedecin(medecin_email);
				rdv.setPatient(patient_email);
				rdv.setSession(session);
				
				rdvs.add(rdv);
			}
		} catch(SQLException e) {
			
		}
		
		System.out.println(rdvs.size());
		
		return rdvs;
		
	}
	
	private void loadDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
		}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_medicale","root","lfsushi5@");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
