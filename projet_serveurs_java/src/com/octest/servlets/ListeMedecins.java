package com.octest.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.CompteMedecin;
import com.octest.beans.Medecin;


@WebServlet("/ListeMedecins")
public class ListeMedecins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListeMedecins() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompteMedecin tableMedecins = new CompteMedecin();
		request.setAttribute("utilisateurs", tableMedecins.recupererMedecins());
		this.getServletContext().getRequestDispatcher("/WEB-INF/listemedecins.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String numero_tel = request.getParameter("numero_tel");
		String adresse = request.getParameter("adresse");
		String password = request.getParameter("password");
		Medecin medecin = new Medecin(email, nom, prenom, numero_tel, adresse, password);
		
	    CompteMedecin tableMedecins = new CompteMedecin();
		tableMedecins.ajouterMedecin(medecin);
		
		request.setAttribute("utilisateurs", tableMedecins.recupererMedecins());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listemedecins.jsp").forward(request, response);
	}

}
