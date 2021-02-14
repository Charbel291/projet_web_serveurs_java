package com.octest.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.RendezVous;

public class ComptePlanning {
private Connection connexion;

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
	
	public List<RendezVous> recupererRdvs(String patient) {
		
		System.out.println(patient);
		
		List<RendezVous> rdvs = new ArrayList<RendezVous>();
		
		loadDatabase();
		
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM rdv WHERE patient_email=?");
			ps.setString(1, patient);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				RendezVous rdv = new RendezVous();
				rdv.setMedecin(rs.getString("medecin_email"));
				rdv.setPatient(rs.getString("patient_email"));
				Timestamp timestamp = rs.getTimestamp("session");
				String session = timestamp.toString();
				rdv.setSession(session);
		
				rdvs.add(rdv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rdvs;
		
	}
	

}
