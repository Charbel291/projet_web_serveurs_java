package com.octest.bdd;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.AnnuaireMedical;

public class Annuaire {
private Connection connexion;
	
	public List<AnnuaireMedical> recupererAnnuaire(){
		List<AnnuaireMedical> annuaire = new ArrayList<AnnuaireMedical>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT medecin_email, specialite, centre_medical FROM annuaire_medical;");
			
			while(resultat.next()) {
				String medecin_email = resultat.getString("medecin_email");
				String specialite = resultat.getString("specialite");
				String centre_medical = resultat.getString("centre_medical");
				
				AnnuaireMedical annuaire_medical = new AnnuaireMedical(medecin_email, specialite, centre_medical);
				
				annuaire.add(annuaire_medical);
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
		
		return annuaire;
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
	
	public void ajouterAnnuaire(AnnuaireMedical annuaire_medical) {
		loadDatabase();
	
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO annuaire_medical(medecin_email, specialite, centre_medical) VALUES(?,?,?);");
			
			preparedStatement.setString(1, annuaire_medical.getMedecin());
			preparedStatement.setString(2, annuaire_medical.getSpecialite());
			preparedStatement.setString(3, annuaire_medical.getCentre_medical());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
