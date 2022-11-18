package com.cyp.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class GetClient
 */
@WebServlet("/GetClient")
public class GetClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOBase daoBase;

    /**
     * Default constructor. 
     */
    public GetClient() {
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
				response.sendRedirect("/Projet-JEE/client");
			} else {
				List<User> userCommande = daoBase.getUser(mail);
				if (userCommande != null) {
					for (User u : userCommande) {
						System.out.println(u.getMail());
					}
					session.setAttribute("client", userCommande);				
				}
				this.getServletContext().getRequestDispatcher("/getClient.jsp").forward(request, response);
			}
		} catch (DAOException e) {
			request.setAttribute("errClient", e.getMessage());
			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("errClient", e.getMessage());
			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
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
