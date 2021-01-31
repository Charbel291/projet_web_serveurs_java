package com.octest.bdd;

import com.octest.beans.Medecin;

import com.octest.beans.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompteMedecin {
private Connection connexion;
	
	public List<Medecin> recupererMedecins(){
		List<Medecin> medecins = new ArrayList<Medecin>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT email, nom, prenom, numero_tel, adresse, password FROM medecins;");
			
			while(resultat.next()) {
				String email = resultat.getString("email");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String numero_tel = resultat.getString("numero_tel");
				String adresse = resultat.getString("adresse");
				String password = resultat.getString("password");
				
				Medecin medecin = new Medecin(email, nom, prenom, numero_tel, adresse, password);
				
				medecins.add(medecin);
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
		
		return medecins;
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
	
	public void ajouterPatient(Medecin medecin) {
		loadDatabase();
	
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO medecins(email, nom, prenom, numero_tel, adresse, password) VALUES(?,?,?,?,?,?,?);");
			
			preparedStatement.setString(1, medecin.getEmail());
			preparedStatement.setString(2, medecin.getNom());
			preparedStatement.setString(3, medecin.getPrenom());
			preparedStatement.setString(4, medecin.getNumero_tel());
			preparedStatement.setString(5, medecin.getAdresse());
			preparedStatement.setString(6, medecin.getPassword());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
