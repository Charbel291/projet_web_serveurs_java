package com.octest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Centres;
import com.octest.bdd.Selection;

@WebServlet("/SelectionCentre")
public class SelectionCentre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectionCentre() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Centres centres = new Centres();
		String patient = request.getParameter("client");
		System.out.println(patient);
		request.setAttribute("patient", patient);
		request.setAttribute("centres", centres.recupererCentres());
		this.getServletContext().getRequestDispatcher("/WEB-INF/selectioncentre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patient = request.getParameter("centre").split(",")[0];
		String centre = request.getParameter("centre").split(",")[1];
		request.setAttribute("patient", patient);
		System.out.println(patient);
		System.out.println(centre);
		request.setAttribute("centre",centre);
		Selection selection = new Selection();
		request.setAttribute("medecins", selection.recupererUtilisateurs(centre));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/schedule.jsp").forward(request, response);
	}

}
