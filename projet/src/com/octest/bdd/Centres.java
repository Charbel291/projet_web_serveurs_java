package com.octest.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Centres {
	private Connection connexion;
	
	public List<String> recupererCentres(){
		List<String> centres = new ArrayList<String>();
		Statement statement = null;
		ResultSet resultat = null;
		
		loadDatabase();
		
		try {
			
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT * FROM liste_centres;");
			
			while(resultat.next()) {
				String centre = resultat.getString("centre_id");
				
				centres.add(centre);
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
		
		return centres;
		
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
