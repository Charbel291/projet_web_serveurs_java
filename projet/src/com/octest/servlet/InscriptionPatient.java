package com.octest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Clients;
import com.octest.bdd.Noms;
import com.octest.beans.Client;
import com.octest.beans.Utilisateur;

@WebServlet("/InscriptionPatient")
public class InscriptionPatient extends HttpServlet {
	
	public static final String VUE = "/WEB-INF/inscriptionpatient.jsp";
    
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = new Client();
		client.setEmail(request.getParameter("email"));
		client.setNom(request.getParameter("nom"));
		client.setPrenom(request.getParameter("prenom"));
		client.setNumero_tel(request.getParameter("numero_tel"));
		client.setAdresse(request.getParameter("adresse"));
		client.setPassword(request.getParameter("password"));
		client.setAnnee_naissance(request.getParameter("annee_naissance"));
		
		Clients tableClients = new Clients();
		tableClients.ajouterClient(client);
		
		request.setAttribute("client",client);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/sessionpatient.jsp").forward(request, response);
	}

}
