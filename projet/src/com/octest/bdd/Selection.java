package com.octest.bdd;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Utilisateur;

import java.sql.Connection;

public class Selection {
	
		private Connection connexion;
		
		public List<Utilisateur> recupererUtilisateurs(String centre){
			List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			
			loadDatabase();
			
			try {
				
				PreparedStatement ps=connexion.prepareStatement("SELECT * FROM medecins, annuaire_medical WHERE centre_id=? and medecins.email=annuaire_medical.medecin_id");  
				ps.setString(1,centre); 
			      
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					String email = rs.getString("email");
					String nom = rs.getString("nom");
					String prenom = rs.getString("prenom");
					String numero_tel = rs.getString("numero_tel");
					String adresse = rs.getString("adresse");
					String password = rs.getString("password");
					
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
				System.out.println(e);
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
		
		
	}

