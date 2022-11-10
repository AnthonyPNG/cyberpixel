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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
