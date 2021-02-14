package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Annuaire;

@WebServlet("/AnnuaireMedecins")
public class AnnuaireMedecins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AnnuaireMedecins() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Annuaire annuaireMedecins = new Annuaire();
		request.setAttribute("annuaire", annuaireMedecins.recupererAnnuaire());
		this.getServletContext().getRequestDispatcher("/WEB-INF/annuairemedecins.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

