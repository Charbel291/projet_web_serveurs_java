package com.octest.bdd;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Login;
import com.octest.beans.Utilisateur;

public class ConnexionPatient {
	private Connection connexion;
	
	public List<Utilisateur> recupererUtilisateurs(){
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT password FROM patients WHERE email= ;");
			
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
	
	public void ajouterUtilisateur(Login login) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("SELECT password FROM patients WHERE email=?;");
			preparedStatement.setString(1, login.getEmail());
			ResultSet resultat=preparedStatement.executeQuery();
			String password=resultat.getString("password");
			if(login.getPassword().equals(password)) {
				
			}else{
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
