package com.octest.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.Client;

public class ClientsUpdate {
	
private Connection connexion;
	
	public List<Client> recupererClients(){
		List<Client> clients = new ArrayList<Client>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT * FROM patients;");
			
			while(resultat.next()) {
				String email = resultat.getString("email");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String numero_tel = resultat.getString("numero_tel");
				String adresse = resultat.getString("adresse");
				String password = resultat.getString("password");
				String annee_naissance = resultat.getString("annee_naissance");
				
				Client client = new Client();
				client.setEmail(email);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setNumero_tel(numero_tel);
				client.setAdresse(adresse);
				client.setPassword(password);
				client.setAnnee_naissance(annee_naissance);
				
				clients.add(client);
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
		
		return clients;
		
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
	
	public void ajouterClient(Client client) {
		loadDatabase();
		
		try {
			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE patients SET nom=?, prenom=?, numero_tel=?, adresse=?, annee_naissance=?, password=? WHERE email=?;");
			preparedStatement.setString(1, client.getNom());
			preparedStatement.setString(2, client.getPrenom());
			preparedStatement.setString(3, client.getNumero_tel());
			preparedStatement.setString(4, client.getAdresse());
			preparedStatement.setString(5, client.getAnnee_naissance());
			preparedStatement.setString(6, client.getPassword());
			preparedStatement.setString(7, client.getEmail());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
