package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.LoginMedecin;
import com.octest.beans.Medecin;


@WebServlet("/ConnexionMedecin")
public class ConnexionMedecin extends HttpServlet {
       
    public ConnexionMedecin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexionmedecin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginMedecin login = new LoginMedecin();
		
		if(login.validate(email, password)) {
			
			Medecin medecin = login.getMedecin(email);
			request.setAttribute("medecin", medecin);
			this.getServletContext().getRequestDispatcher("/WEB-INF/sessionmedecin.jsp").forward(request, response);
		}else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexionmedecin.jsp").forward(request, response);
		}
	}

}
