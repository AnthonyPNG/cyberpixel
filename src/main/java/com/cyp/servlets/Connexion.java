package com.cyp.servlets;

import java.io.IOException;

import com.cyp.dao.DAOBase;
import com.cyp.dao.DAOException;
import com.cyp.dao.DAOFactory;
import com.cyp.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public Connexion() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	DAOFactory daoFactory = DAOFactory.getInstance();
    	daoBase = daoFactory.getDao();
    }

	/**
	 * Affiche la page de connexion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
	}

	/**
	 * Vérifie la connexion d'un utilisateur
	 * Si le mail et le mdp sont bons, ouvre une session user connecte
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		try {
			if (mail.equals("") || mdp.equals("")) throw new Exception("Veuillez saisir tous les champs.");
			User userConnecte = daoBase.connecterUser(mail, mdp);
			if (userConnecte != null) {
				session.setAttribute("connecte", userConnecte);				
			}
			response.sendRedirect("/Projet-JEE/boutique");
		} catch (DAOException e) {
			request.setAttribute("errConnexion", e.getMessage());
			this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errConnexion", e.getMessage());
			this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
		}
	}

}
