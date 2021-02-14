package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.PlanningMedecin;

@WebServlet("/ListeRdvs")
public class ListeRdvs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListeRdvs() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medecin = request.getParameter("medecin");
		System.out.println(medecin);
		request.setAttribute("medecin", medecin);
		
		PlanningMedecin planning_medecin = new PlanningMedecin();
		System.out.println(planning_medecin.recupererRdvs(medecin).size());
		request.setAttribute("rdvs", planning_medecin.recupererRdvs(medecin));
		this.getServletContext().getRequestDispatcher("/WEB-INF/listerdvs.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
