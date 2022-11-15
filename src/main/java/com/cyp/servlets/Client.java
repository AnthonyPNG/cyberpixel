package com.cyp.servlets;

import java.io.IOException;

import com.cyp.dao.DAOBase;
import com.cyp.dao.DAOException;
import com.cyp.dao.DAOFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public Client() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	DAOFactory daoFactory = DAOFactory.getInstance();
    	daoBase = daoFactory.getDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("clients", daoBase.getListUser());
		} catch (DAOException e) {
			request.setAttribute("errClient", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		int passerCommande;
		int payerCommande;
		
		try {
			if (request.getParameter("majUser") != null) {
				id = Integer.parseInt(request.getParameter("majUser"));			
				if (request.getParameter("passerCmd") == null) passerCommande = 0;
				else passerCommande = Integer.parseInt(request.getParameter("passerCmd"));
				if (request.getParameter("payerCmd") == null) payerCommande = 0;
				else payerCommande = Integer.parseInt(request.getParameter("payerCmd"));
				System.out.println(id);
				System.out.println("passer: " + passerCommande);
				System.out.println("payer: " + payerCommande);
				daoBase.UpdateDroits(id, passerCommande, payerCommande);
			}
			if (request.getParameter("supprimerUser") != null) {
				id = Integer.parseInt(request.getParameter("supprimerUser"));
				daoBase.removeUser(id);
			}
		} catch (DAOException e) {
			request.setAttribute("errClient", e.getMessage());
		}
		response.sendRedirect("/Projet-JEE/client");
	}

}
