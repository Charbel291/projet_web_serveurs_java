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

public class ReservationCreneau {
private Connection connexion;

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
	
	public void ajouterCreneau(String medecin, String patient, String creneau) {
		loadDatabase();
		
		try {
			PreparedStatement ps = connexion.prepareStatement("INSERT INTO rdv(medecin_email, patient_email, session) VALUES (?,?,?);");
			ps.setString(1, medecin);
			ps.setString(2, patient);
			ps.setString(3, creneau);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
