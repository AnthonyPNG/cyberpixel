package com.cyp.servlets;

import java.io.IOException;

import com.cyp.dao.DAOBase;
import com.cyp.dao.DAOException;
import com.cyp.dao.DAOFactory;
import com.cyp.models.ArticlePanier;
import com.cyp.models.Produit;
import com.cyp.models.ShoppingPanier;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public Panier() {
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
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("ajouterProd"));
		ShoppingPanier panier = new ShoppingPanier();
		
		try {
			Produit p = daoBase.getProduit(id);
			panier.ajouterProduit(p);
			System.out.println(panier.items.size());
			session.setAttribute("articles", panier);
			for (ArticlePanier i : panier.items) {
				System.out.println(i.produit);
			}
		} catch (DAOException e) {
			request.setAttribute("errPanier", e.getMessage());
		}
		
		response.sendRedirect("/Projet-JEE/boutique");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
