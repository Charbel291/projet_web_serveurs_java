package com.octest.servlets;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.CompteMedecin;
import com.octest.bdd.ComptePatient;
import com.octest.beans.Utilisateur;


@WebServlet("/Test")
public class Test extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteMedecin tableMedecins = new CompteMedecin();
		request.setAttribute("utilisateurs", tableMedecins.recupererMedecins());
		System.out.println(tableMedecins.recupererMedecins().size());
		String message = "au revoir";
		request.setAttribute("variable", message);
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

}
