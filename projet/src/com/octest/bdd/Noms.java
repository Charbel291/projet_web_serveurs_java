package com.octest.bdd;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateur;

public class Noms {
	private Connection connexion;
	
	public List<Utilisateur> recupererUtilisateurs(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
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
				
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setEmail(email);
				utilisateur.setNom(nom);
				utilisateur.setPrenom(prenom);
				utilisateur.setNumero_tel(numero_tel);
				utilisateur.setAdresse(adresse);
				utilisateur.setPassword(password);
				
				utilisateurs.add(utilisateur);
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
		
		return utilisateurs;
		
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
	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO medecins(email, nom, prenom, numero_tel, adresse, password) VALUES (?,?,?,?,?,?);");
			preparedStatement.setString(1, utilisateur.getEmail());
			preparedStatement.setString(2, utilisateur.getNom());
			preparedStatement.setString(3, utilisateur.getPrenom());
			preparedStatement.setString(4, utilisateur.getNumero_tel());
			preparedStatement.setString(5, utilisateur.getAdresse());
			preparedStatement.setString(6, utilisateur.getPassword());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
