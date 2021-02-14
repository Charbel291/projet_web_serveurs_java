package com.octest.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Centres;
import com.octest.bdd.Noms;
import com.octest.bdd.Rdv;
import com.octest.beans.RendezVous;


@WebServlet("/Planning")
public class Planning extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Planning() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		Noms tableNoms = new Noms();
	
		request.setAttribute("medecins",tableNoms.recupererUtilisateurs());
		*/
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/schedule.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dd = request.getParameter("dd");
		String mm = request.getParameter("mm");
		String aaaa = request.getParameter("aaaa");
		
		String medecin = request.getParameter("medecin");
		
		String patient = request.getParameter("client");
		
		request.setAttribute("medecin", medecin);
		
		request.setAttribute("patient", patient);
		
		System.out.println(patient);
		
		System.out.println(medecin);
		
		String date = aaaa+"-"+mm+"-"+dd;
		request.setAttribute("date", date);
		
		System.out.println(dd);
		System.out.println(mm);
		System.out.println(aaaa);
		
		System.out.println(date);
		
		request.setAttribute("date",date);
		
		Rdv rdv = new Rdv();
		List<RendezVous> rdvs = rdv.getRendezVous(date, medecin);
		
		System.out.println(rdvs.size());
		
		List<String> creneaux = new ArrayList<String>();
		
		if(rdvs.size()>0) {
			for(int i=0; i<rdvs.size(); i++) {
				RendezVous rendezvous = rdvs.get(i);
				creneaux.add(rendezvous.getSession().substring(11,16));
				System.out.println(rendezvous.getSession().substring(11,16));
			}
		}
		request.setAttribute("creneaux", creneaux);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/reservation.jsp").forward(request, response);
		
		/*
		String date = request.getParameter("param1");
		System.out.println(date);
		Rdv rdv = new Rdv();
		List<RendezVous> rdvs = rdv.getRendezVous(date);
		System.out.println(rdvs.size());
		String medecin=rdvs.get(0).getMedecin();
		System.out.println("medecin "+medecin);
		System.out.println("patient "+rdvs.get(0).getPatient());
		System.out.println("session "+rdvs.get(0).getSession());
	
		request.setAttribute("medecin", medecin);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/planning.jsp").forward(request, response);
		*/
		
		
	}

}
