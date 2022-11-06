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

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public Inscription() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	DAOFactory daoFactory = DAOFactory.getInstance();
    	this.daoBase = daoFactory.getDao();
    }

	/**
	 * Affiche la page inscription
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

	/**
	 * Ajoute les informations du user dans la BDD
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = new User();
		
		try {
			u.setNom(request.getParameter("nom"));
			u.setPrenom(request.getParameter("prenom"));
			u.setAdresse(request.getParameter("adresse"));
			u.setMail(request.getParameter("mail"));
			String mdp = request.getParameter("mdp1");
			String checkMdp = request.getParameter("mdp2");
			if (u.getNom().equals("") || u.getPrenom().equals("") || u.getAdresse().equals("") || u.getMail().equals("") || 
					mdp.equals("") || checkMdp.equals("")) throw new Exception("Veuillez saisir tous les champs.");
			if (!mdp.equals(checkMdp)) throw new Exception("Ces mots de passe ne correspondent pas. Veuillez réessayer.");
			else u.setMdp(mdp);
			daoBase.ajouterUser(u);
		} catch (DAOException e) {
			request.setAttribute("errInscription", e.getMessage());
		} catch (Exception e) {
			request.setAttribute("errInscription", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

}
