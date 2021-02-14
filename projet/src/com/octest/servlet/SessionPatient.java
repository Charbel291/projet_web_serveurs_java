package com.octest.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.ClientsUpdate;
import com.octest.beans.Client;

@WebServlet("/SessionPatient")
public class SessionPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/sessionpatient.jsp").forward(request, response);
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
		
		ClientsUpdate tableClients = new ClientsUpdate();
		tableClients.ajouterClient(client);
		
		request.setAttribute("client",client);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/sessionpatient.jsp").forward(request, response);
	}

}
