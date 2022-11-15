package com.cyp.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import com.cyp.dao.DAOBase;
import com.cyp.dao.DAOFactory;
import com.cyp.models.Produit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjouterProduit
 */
@WebServlet("/AjouterProduit")
public class AjouterProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public AjouterProduit() {
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
		this.getServletContext().getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Produit p = new Produit();
		try
		{
			p.setNom(request.getParameter("nom"));
			p.setPrix(BigDecimal.valueOf(Double.valueOf(request.getParameter("prix"))));
			p.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			if (request.getParameter("description").equals(null)) p.setDescription("");
			else p.setDescription(request.getParameter("description"));			
			if (request.getParameter("description").equals(null)) p.setUrl("");
			else p.setUrl(request.getParameter("url"));
			daoBase.ajouterProduit(p);
			response.sendRedirect("/Projet-JEE/produit");
		}
		catch(NumberFormatException ex)
		{
			request.setAttribute("errAjoutProduit", "Veuillez saisir un prix et/ou une quantite correct !");
			this.getServletContext().getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
		}
		
		catch(Exception ex)
		{
			request.setAttribute("errAjoutProduit", ex.getMessage());
			this.getServletContext().getRequestDispatcher("/ajouterProduit.jsp").forward(request, response);
		}
	}

}
