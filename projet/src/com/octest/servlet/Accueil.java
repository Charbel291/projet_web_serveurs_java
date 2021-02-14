package com.octest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Accueil() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String profil = request.getParameter("profil");
		if(profil.equals("Administrateur")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexionadmin.jsp").forward(request, response);
		}else if(profil.equals("Medecin")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexionmedecin.jsp").forward(request, response);
		}else if(profil.equals("Patient")) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexionpatient.jsp").forward(request, response);
		}
	}

}
