package com.octest.bdd;

import com.octest.beans.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Noms {
	private Connection connexion;
	
	public List<Utilisateur> recupererUtilisateurs(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			statement = connexion.createStatement();
			
			//Execution de la requete
			resultat = statement.executeQuery("SELECT nom, prenom FROM noms;");
			
			//Recuperation des donnees
			while(resultat.next()) {
				String nom = resultat.getString("nom");
				System.out.println(nom);
				String prenom = resultat.getString("prenom");
				System.out.println(prenom);
				
				Utilisateur utilisateur  = new Utilisateur();
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				
				utilisateurs.add(utilisateur);
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
		
		return utilisateurs;
	}
	
	private void loadDatabase() {
		// Chargement du driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
		}
		
		try {
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "lfsushi5@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		loadDatabase();
	
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO noms(nom, prenom) VALUES(?,?);");
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
