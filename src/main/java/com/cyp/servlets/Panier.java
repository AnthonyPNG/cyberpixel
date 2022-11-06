package com.cyp.servlets;

import java.io.IOException;
import java.math.BigDecimal;

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
	ShoppingPanier panier = new ShoppingPanier();
	BigDecimal prixTotal;

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
	 * Affiche le panier
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("ajouterProd"));
		prixTotal = BigDecimal.ZERO;
		
		try {
			Produit p = daoBase.getProduit(id);
			panier.ajouterProduit(p);
			session.setAttribute("paniers", panier);
			for (ArticlePanier article : panier.getArticles()) {
				BigDecimal prixProduit = article.getPrix().multiply(BigDecimal.valueOf(article.getQuantite()));
				prixTotal = prixTotal.add(prixProduit);
			}
			session.setAttribute("prixTotal", prixTotal);
		} catch (DAOException e) {
			request.setAttribute("errPanier", e.getMessage());
		}
		
		response.sendRedirect("/Projet-JEE/boutique");
	}

	/**
	 * Ajouter un produit
	 * Retirer un produit
	 * Supprimer un produit
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id;
		prixTotal = BigDecimal.ZERO;
		
		try {
			if (request.getParameter("ajouterProd") != null) {
				id = Integer.parseInt(request.getParameter("ajouterProd"));
				Produit p = daoBase.getProduit(id);
				panier.ajouterProduit(p);
			}
			if (request.getParameter("retirerProd") != null) {
				id = Integer.parseInt(request.getParameter("retirerProd"));
				Produit p = daoBase.getProduit(id);
				panier.retirerProduit(p);
			}
			if (request.getParameter("supprimerProd") != null) {
				id = Integer.parseInt(request.getParameter("supprimerProd"));
				Produit p = daoBase.getProduit(id);
				panier.supprimerProduit(p);
			}
			session.setAttribute("paniers", panier);
			
			for (ArticlePanier article : panier.getArticles()) {
				BigDecimal prixProduit = article.getPrix().multiply(BigDecimal.valueOf(article.getQuantite()));
				prixTotal = prixTotal.add(prixProduit);
			}
			session.setAttribute("prixTotal", prixTotal);
		} catch (DAOException e) {
			request.setAttribute("errPanier", e.getMessage());
		}
		
		response.sendRedirect("/Projet-JEE/boutique");
	}

}
