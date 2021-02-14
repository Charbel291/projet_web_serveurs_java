package com.octest.bdd;
import java.sql.*;

public class LoginAdmin {
	private Connection connexion;
	
	public boolean validate(String email,String password){  
		boolean status=false;  
		
		loadDatabase();
		
		try{
		   
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM administrateurs WHERE admin_id=? and password=?");  
			ps.setString(1,email);  
			ps.setString(2,password);  
		      
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		          
		}catch(Exception e){
			System.out.println(e);
		}  
		
		return status;  
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


