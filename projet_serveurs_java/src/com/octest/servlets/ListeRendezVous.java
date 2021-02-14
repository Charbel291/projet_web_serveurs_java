package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Planning;

@WebServlet("/ListeRendezVous")
public class ListeRendezVous extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListeRendezVous() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Planning planning = new Planning();
		request.setAttribute("listerdvs", planning.recupererPlanning());
		this.getServletContext().getRequestDispatcher("/WEB-INF/listerendezvous.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
