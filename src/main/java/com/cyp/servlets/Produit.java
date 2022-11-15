package com.cyp.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import com.cyp.dao.DAOBase;
import com.cyp.dao.DAOException;
import com.cyp.dao.DAOFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Produit
 */
@WebServlet("/Produit")
public class Produit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public Produit() {
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
			request.setAttribute("produits", daoBase.getListProduit());
		} catch (DAOException e) {
			request.setAttribute("errProduit", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/produit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		
		try {
			if (request.getParameter("majProduit") != null) {
				id = Integer.parseInt(request.getParameter("majProduit"));
				if (!request.getParameter("prix").equals("")) {					
					BigDecimal prix = BigDecimal.valueOf(Double.valueOf(request.getParameter("prix")));
					daoBase.updatePrixProduit(prix, id);
				} else {
					int quantite = Integer.parseInt(request.getParameter("quantite"));
					daoBase.updateStockProduit(quantite, id);
				}
			}
			if (request.getParameter("supprimerProduit") != null) {
				id = Integer.parseInt(request.getParameter("supprimerProduit"));
				daoBase.removeProduit(id);
			}
		} catch (DAOException e) {
			request.setAttribute("errProduit", e.getMessage());
		}
		response.sendRedirect("/Projet-JEE/produit");
	}

}
