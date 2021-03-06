package com.octest.bdd;
import java.sql.*;


import com.octest.beans.Medecin;


public class LoginMedecin {
	private Connection connexion;
	
	public boolean validate(String email,String password){  
		boolean status=false;  
		
		loadDatabase();
		
		try{
		   
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM medecins WHERE email=? and password=?");  
			ps.setString(1,email);  
			ps.setString(2,password);  
		      
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		          
		}catch(Exception e){
			System.out.println(e);
		}  
		
		return status;  
	}
	
	public Medecin getMedecin(String email) {
		loadDatabase();
		System.out.println(email);
		Medecin medecin = new Medecin();
		
		try{
			System.out.println("hello");
			
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM medecins WHERE email=?");  
			ps.setString(1,email);   
		      
			ResultSet rs=ps.executeQuery();
			
			rs.next();
			
			System.out.println(rs.getString("nom"));
			
			medecin.setEmail(rs.getString("email"));
			medecin.setNom(rs.getString("nom"));
			medecin.setPrenom(rs.getString("prenom"));
			medecin.setAdresse(rs.getString("adresse"));
			medecin.setNumero_tel(rs.getString("numero_tel"));
			medecin.setPassword(rs.getString("password"));
		          
		}catch(Exception e){
			System.out.println(e);
		}
		
		return medecin;
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


