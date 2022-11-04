package com.cyp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cyp.models.Produit;
import com.cyp.models.User;

public class DAOBase {
	private DAOFactory daoFactory;
	
	DAOBase(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	public List<Produit> getListProduit() throws DAOException {
		List<Produit> produits = new ArrayList<Produit>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM produit");
			
			while (result.next()) {
				int id = result.getInt("idproduit");
				String nom = result.getString("nom");
				double prix = result.getDouble("prix");
				int quantite = result.getInt("quantite");
				String description = result.getString("description");
				String url = result.getString("url");
				
				Produit produit = new Produit();
				produit.setIdproduit(id);
				produit.setNom(nom);
				produit.setPrix(prix);
				produit.setQuantite(quantite);
				produit.setDescription(description);
				produit.setUrl(url);
				
				produits.add(produit);
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return produits;
 	}
	
	public Produit getProduit(int id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Produit p = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM produit WHERE idproduit = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			
			if (result.next()) {
				p = new Produit();
				p.setNom(result.getString("nom"));
				p.setPrix(result.getInt("prix"));
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return p;
	}
	
	public List<User> getListUser() throws DAOException {
		List<User> users = new ArrayList<User>();
		Connection connexion = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connexion = daoFactory.getConnection();
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM user WHERE role = 'client'");
			
			while (result.next()) {
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String mail = result.getString("mail");
				byte passerCommande = result.getByte("passer_commande");
				byte payerCommande = result.getByte("payer_commande");
				
				User user = new User();
				user.setNom(nom);
				user.setPrenom(prenom);
				user.setMail(mail);
				user.setPasserCommande(passerCommande);
				user.setPayerCommande(payerCommande);
				
				users.add(user);
			} 
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return users;
	}
	
	public void ajouterUser(User u) throws DAOException {
		Connection connexion = null;
		PreparedStatement checkedStatement = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			
			// Vérifie si le mail est déjà utilisé
			checkedStatement = connexion.prepareStatement("SELECT * FROM user where mail = ?");
			checkedStatement.setString(1, u.getMail());
			result = checkedStatement.executeQuery();
			if (result.next()) throw new DAOException("Mail déjà utilisé");
			else {
				preparedStatement = connexion.prepareStatement("INSERT INTO user VALUES (DEFAULT, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, DEFAULT, ?)");
				preparedStatement.setString(1, u.getNom());
				preparedStatement.setString(2, u.getPrenom());
				preparedStatement.setString(3, u.getMail());
				preparedStatement.setString(4, u.getAdresse());
				preparedStatement.setString(5, u.getMdp());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
	}
	
	public User connecterUser(String mail, String mdp) throws DAOException {
		User u = null;
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM user WHERE mail = ? AND mdp = ?");
			preparedStatement.setString(1, mail);
			preparedStatement.setString(2, mdp);
			result = preparedStatement.executeQuery();
			
			if (result.next()) {
				result.first();
				u = new User();
				u.setNom(result.getString("nom"));
				u.setPrenom(result.getString("prenom"));
				u.setRole(result.getString("role"));
				u.setPasserCommande(result.getByte("passer_commande"));
				u.setPayerCommande(result.getByte("payer_commande"));
			} else {
				throw new DAOException("Les champs saisis sont incorrects!");
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return u;
	}
}
