package com.octest.bdd;
import java.sql.*;


import com.octest.beans.Client;


public class LoginDao {
	private Connection connexion;
	
	public boolean validate(String email,String password){  
		boolean status=false;  
		
		loadDatabase();
		
		try{
		   
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM patients WHERE email=? and password=?");  
			ps.setString(1,email);  
			ps.setString(2,password);  
		      
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		          
		}catch(Exception e){
			System.out.println(e);
		}  
		
		return status;  
	}
	
	public Client getClient(String email) {
		loadDatabase();
		System.out.println(email);
		Client client = new Client();
		
		try{
			System.out.println("hello");
			
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM patients WHERE email=?");  
			ps.setString(1,email);   
		      
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			
			System.out.println(rs.getString("nom"));
			
			client.setEmail(rs.getString("email"));
			client.setNom(rs.getString("nom"));
			client.setPrenom(rs.getString("prenom"));
			client.setAdresse(rs.getString("adresse"));
			client.setNumero_tel(rs.getString("numero_tel"));
			client.setAnnee_naissance(rs.getString("annee_naissance"));
			client.setPassword(rs.getString("password"));
		          
		}catch(Exception e){
			System.out.println(e);
		}
		
		return client;
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


