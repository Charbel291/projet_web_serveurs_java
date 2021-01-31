package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.ComptePatient;

@WebServlet("/ListePatients")
public class ListePatients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListePatients() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComptePatient tablePatients = new ComptePatient();
		request.setAttribute("utilisateurs", tablePatients.recupererPatients());
		this.getServletContext().getRequestDispatcher("/WEB-INF/listepatients.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
