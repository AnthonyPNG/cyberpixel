package com.cyp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
	// initialise le DAO en chargeant les drivers
	// et se connecte a la BDD
	private String url;
	private String username;
	private String password;
	
	DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DAOFactory getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
		}
		
		DAOFactory instance = new DAOFactory("jdbc:mysql://localhost:3306/cyberpixel", "root", "root");
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public DAOBase getDao() {
		return new DAOBase(this);
	}
}
