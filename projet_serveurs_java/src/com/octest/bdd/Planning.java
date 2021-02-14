package com.octest.bdd;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.RendezVous;

public class Planning {
private Connection connexion;
	
	public List<RendezVous> recupererPlanning(){
		List<RendezVous> listerendezvous = new ArrayList<RendezVous>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT medecin_email, patient_email, session FROM rdv;");
			
			while(resultat.next()) {
				String medecin_email = resultat.getString("medecin_email");
				String patient_email = resultat.getString("patient_email");
				String session = resultat.getString("session");
				
				RendezVous rendezvous = new RendezVous(medecin_email, patient_email, session);
				listerendezvous.add(rendezvous);
			}
		} catch(SQLException e) {
		} finally {
			
			try {
				if(resultat != null)
					resultat.close();
				if(statement != null)
					statement.close();
				if(connexion != null)
					connexion.close();
			} catch(SQLException ignore) {
			}
		}
		
		return listerendezvous;
	}
	
	private void loadDatabase() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
		}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_medicale", "root", "lfsushi5@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterAnnuaire(RendezVous rendezvous) {
		loadDatabase();
	
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO rdv(medecin_email, patient_email, session) VALUES(?,?,?);");
			
			preparedStatement.setString(1, rendezvous.getMedecin());
			preparedStatement.setString(2, rendezvous.getPatient());
			preparedStatement.setString(3, rendezvous.getSession());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
