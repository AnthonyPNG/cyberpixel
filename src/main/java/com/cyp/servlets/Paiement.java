package com.cyp.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import com.cyp.dao.DAOBase;
import com.cyp.dao.DAOException;
import com.cyp.dao.DAOFactory;
import com.cyp.models.ArticlePanier;
import com.cyp.models.Cb;
import com.cyp.models.Commande;
import com.cyp.models.Produit;
import com.cyp.models.ShoppingPanier;
import com.cyp.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Paiement
 */
@WebServlet("/Paiement")
public class Paiement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public Paiement() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	DAOFactory daoFactory = DAOFactory.getInstance();
    	daoBase = daoFactory.getDao();
    }

	/**
	 * Affiche la page de paiement
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/paiement.jsp").forward(request, response);
	}

	/**
	 * Vérification des donnees et acceptation
	 * Abandon de l'operation
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		HttpSession session = request.getSession();
		Commande commande = null;
		User user = (User) session.getAttribute("connecte");
		String action = request.getParameter("action");
		
		try {
			if (action.equals("Abandonner")) {
				response.sendRedirect("/Projet-JEE/boutique");
			} else if (action.equals("Valider")) {
				String nom = request.getParameter("nom");
				Long num = Long.parseLong(request.getParameter("num"));
				String date = request.getParameter("date");
				int cryptogramme = Integer.parseInt(request.getParameter("cvv"));
				
				if (nom.equals("") || request.getParameter("num").equals("") || date.equals("") || 
						request.getParameter("cvv").equals("") ) throw new Exception("Veuillez saisir tous les champs.");
				
				Cb cb = daoBase.getCb(nom, num, date, cryptogramme);
				if (cb != null) {
					BigDecimal prix = (BigDecimal) session.getAttribute("prixTotal");
					
					if (cb.getSolde().compareTo(prix) == -1) {
						throw new Exception("Vous ne pouvez pas effectuer votre paiement car votre solde est inférieur au prix à payer !");
					} else {
						cb.setSolde(cb.getSolde().subtract(prix));
						daoBase.updateCbSolde(cb);
						
						ShoppingPanier panier = (ShoppingPanier) session.getAttribute("paniers");
						for (ArticlePanier article : panier.getArticles()) {
							Produit p = daoBase.getProduit(article.produit.getNom());
							p.setQuantite(p.getQuantite() - article.getQuantite());
							daoBase.updateProduitQuantite(p);
						}
						
						// Current Date
						long millis=System.currentTimeMillis();
						Date ddate = new Date(millis);
						commande = new Commande();
						commande.setMail(user.getMail());
						commande.setPrix(prix);
						daoBase.ajouterCommande(commande, ddate);

					}
					
					response.sendRedirect("/Projet-JEE/paiementValide");
				} else {
					throw new DAOException("Les informations fournies ne correspondent pas !");
				}
			}
		} catch(NumberFormatException e) {
			request.setAttribute("errPaiement", "Veuillez entrer un N° de carte et/ou un cryptogramme correct !");
			this.getServletContext().getRequestDispatcher("/paiement.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errPaiement", e.getMessage());
			this.getServletContext().getRequestDispatcher("/paiement.jsp").forward(request, response);
		}
	}

}
