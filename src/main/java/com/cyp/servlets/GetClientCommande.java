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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetClientCommande
 */
@WebServlet("/GetClientCommande")
public class GetClientCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public GetClientCommande() {
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
		String mail = request.getParameter("mail");
		
		try {
			if (mail.equals("") || mail == null) {
				response.sendRedirect("/Projet-JEE/commande");
			} else {
				session.setAttribute("commandesClient", daoBase.getListCommandeForAdmin(mail));
				this.getServletContext().getRequestDispatcher("/getClientCommande.jsp").forward(request, response);
			}
		} catch (DAOException e) {
			request.setAttribute("errProduit", e.getMessage());
			this.getServletContext().getRequestDispatcher("/commande.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errProduit", e.getMessage());
			this.getServletContext().getRequestDispatcher("/commande.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
