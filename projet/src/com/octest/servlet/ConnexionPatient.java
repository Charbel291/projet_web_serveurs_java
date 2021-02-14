package com.octest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.LoginDao;
import com.octest.beans.Client;


@WebServlet("/ConnexionPatient")
public class ConnexionPatient extends HttpServlet {
       
    public ConnexionPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/connexionpatient.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginDao login = new LoginDao();
		
		if(login.validate(email, password)) {
			
			Client client = login.getClient(email);
			request.setAttribute("client", client);
			this.getServletContext().getRequestDispatcher("/WEB-INF/sessionpatient.jsp").forward(request, response);
		}else{
			this.getServletContext().getRequestDispatcher("/WEB-INF/connexionpatient.jsp").forward(request, response);
		}
	}

}
