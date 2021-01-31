package com.octest.bdd;

import com.octest.beans.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ComptePatient {
	private Connection connexion;
	
	public List<Patient> recupererPatients(){
		List<Patient> patients = new ArrayList<Patient>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT email, nom, prenom, numero_tel, adresse, annee_naissance, password FROM patients;");
			
			while(resultat.next()) {
				String email = resultat.getString("email");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String numero_tel = resultat.getString("numero_tel");
				String adresse = resultat.getString("adresse");
				String annee_naissance = resultat.getString("annee_naissance");
				String password = resultat.getString("password");
				
				Patient patient = new Patient(email, nom, prenom, numero_tel, adresse, annee_naissance, password);
				
				patients.add(patient);
			}
		} catch(SQLException e) {
		} finally {
			// Fermeture de la connexion
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
		
		return patients;
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
	
	public void ajouterPatient(Patient patient) {
		loadDatabase();
	
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO patients(email, nom, prenom, numero_tel, adresse, annee_naissance, password) VALUES(?,?,?,?,?,?,?);");
			
			preparedStatement.setString(1, patient.getEmail());
			preparedStatement.setString(2, patient.getNom());
			preparedStatement.setString(3, patient.getPrenom());
			preparedStatement.setString(4, patient.getNumero_tel());
			preparedStatement.setString(5, patient.getAdresse());
			preparedStatement.setString(6, patient.getAnnee_naissance());
			preparedStatement.setString(7, patient.getPassword());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
