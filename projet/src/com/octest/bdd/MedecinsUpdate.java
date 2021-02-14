package com.octest.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Medecin;

public class MedecinsUpdate {
	
private Connection connexion;
	
	public List<Medecin> recupererMedecins(){
		List<Medecin> medecins = new ArrayList<Medecin>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT * FROM medecins;");
			
			while(resultat.next()) {
				String email = resultat.getString("email");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String numero_tel = resultat.getString("numero_tel");
				String adresse = resultat.getString("adresse");
				String password = resultat.getString("password");
				
				Medecin medecin = new Medecin();
				medecin.setEmail(email);
				medecin.setNom(nom);
				medecin.setPrenom(prenom);
				medecin.setNumero_tel(numero_tel);
				medecin.setAdresse(adresse);
				medecin.setPassword(password);
				
				medecins.add(medecin);
			}
		} catch(SQLException e) {
			
		} finally {
			try {
				if(resultat!=null)
					resultat.close();
				if(statement!=null)
					statement.close();
				if(connexion!=null)
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
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_medicale","root","lfsushi5@");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterMedecin(Medecin medecin) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE medecins SET nom=?, prenom=?, numero_tel=?, adresse=?, password=? WHERE email=?;");
			preparedStatement.setString(1, medecin.getNom());
			preparedStatement.setString(2, medecin.getPrenom());
			preparedStatement.setString(3, medecin.getNumero_tel());
			preparedStatement.setString(4, medecin.getAdresse());
			preparedStatement.setString(5, medecin.getPassword());
			preparedStatement.setString(6, medecin.getEmail());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
