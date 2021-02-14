package com.octest.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.LoginDao;
import com.octest.bdd.ReservationCreneau;
import com.octest.beans.Client;

@WebServlet("/Reservation")
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reservation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String session = request.getParameter("session");
		session+=":00";
		String medecin = session.split(",")[0];
		String patient = session.split(",")[1];
		String creneau = session.split(",")[2];
		request.setAttribute("medecin", medecin);
		request.setAttribute("patient", patient);
		request.setAttribute("creneau", creneau);
		System.out.println(medecin);
		System.out.println(patient);
		System.out.println(creneau);
		System.out.println(session);
		
		ReservationCreneau reservation = new ReservationCreneau();
		reservation.ajouterCreneau(medecin, patient, creneau);
		
		LoginDao login = new LoginDao();
		Client client = login.getClient(patient);
		request.setAttribute("client", client);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/sessionpatient.jsp").forward(request, response);
	}

}
