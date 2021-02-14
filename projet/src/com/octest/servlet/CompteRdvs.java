package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.ComptePlanning;

@WebServlet("/CompteRdvs")
public class CompteRdvs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CompteRdvs() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patient = request.getParameter("client");
		System.out.println(patient);
		request.setAttribute("patient", patient);
		
		ComptePlanning compte_planning = new ComptePlanning();
		System.out.println(compte_planning.recupererRdvs(patient).size());
		request.setAttribute("rdvs", compte_planning.recupererRdvs(patient));
		this.getServletContext().getRequestDispatcher("/WEB-INF/mesrdvs.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
