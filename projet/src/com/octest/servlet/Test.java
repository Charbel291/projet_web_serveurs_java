package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Medecin;
import com.octest.beans.Utilisateur;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noms tableNoms = new Noms();
		
		request.setAttribute("utilisateurs",tableNoms.recupererUtilisateurs());
		/*
		Medecin medecin = new Medecin("john.doe@gmail.com","Doe","John","5 rue de Rivoli","0689257280","johndoe");
		request.setAttribute("medecin", medecin);
		String message = "Au revoir !";
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		request.setAttribute("variable", message);
		*/
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setEmail(request.getParameter("email"));
		utilisateur.setNom(request.getParameter("nom"));
		utilisateur.setPrenom(request.getParameter("prenom"));
		utilisateur.setNumero_tel(request.getParameter("numero_tel"));
		utilisateur.setAdresse(request.getParameter("adresse"));
		utilisateur.setPassword(request.getParameter("password"));
		
		Noms tableNoms = new Noms();
		tableNoms.ajouterUtilisateur(utilisateur);
		
		request.setAttribute("utilisateurs",tableNoms.recupererUtilisateurs());
//		String nom = request.getParameter("nom");
		
//		request.setAttribute("nom", nom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
	}

}
