package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.MedecinsUpdate;
import com.octest.beans.Medecin;

@WebServlet("/SessionMedecin")
public class SessionMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionMedecin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/sessionmedecin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Medecin medecin = new Medecin();
		medecin.setEmail(request.getParameter("email"));
		medecin.setNom(request.getParameter("nom"));
		medecin.setPrenom(request.getParameter("prenom"));
		medecin.setNumero_tel(request.getParameter("numero_tel"));
		medecin.setAdresse(request.getParameter("adresse"));
		medecin.setPassword(request.getParameter("password"));
		
		MedecinsUpdate tableMedecins = new MedecinsUpdate();
		tableMedecins.ajouterMedecin(medecin);
		
		request.setAttribute("medecin",medecin);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/sessionmedecin.jsp").forward(request, response);
	}

}
