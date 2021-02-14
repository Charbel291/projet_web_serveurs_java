package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.LoginAdmin;
import com.octest.bdd.Noms;


@WebServlet("/ConnexionAdmin")
public class ConnexionAdmin extends HttpServlet {
       
    public ConnexionAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexionadmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginAdmin login = new LoginAdmin();
		
		if(login.validate(email, password)) {
			Noms tableNoms = new Noms();
			request.setAttribute("admin", email);
			request.setAttribute("utilisateurs",tableNoms.recupererUtilisateurs());
			this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
		}else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexionadmin.jsp").forward(request, response);
		}
	}

}
