package com.cyp.dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cyp.models.Cb;
import com.cyp.models.Produit;
import com.cyp.models.User;

public class DAOBase {
	private DAOFactory daoFactory;
	
	DAOBase(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	// Renvoie la liste de produits
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
				BigDecimal prix = result.getBigDecimal("prix");
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
	
	// Renvoie le produit de l'id donne
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
				p.setIdproduit(result.getInt("idproduit"));
				p.setNom(result.getString("nom"));
				p.setPrix(result.getBigDecimal("prix"));
				p.setQuantite(result.getInt("quantite"));
				p.setDescription(result.getString("description"));
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return p;
	}
	
	// Renvoie le produit du nom donne
	public Produit getProduit(String nom) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		Produit p = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM produit WHERE nom = ?");
			preparedStatement.setString(1, nom);
			result = preparedStatement.executeQuery();
			
			if (result.next()) {
				p = new Produit();
				p.setIdproduit(result.getInt("idproduit"));
				p.setNom(result.getString("nom"));
				p.setPrix(result.getBigDecimal("prix"));
				p.setQuantite(result.getInt("quantite"));
				p.setDescription(result.getString("description"));
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return p;
	}
	
	// Ajoute un produit 
	public void ajouterProduit(Produit p) throws DAOException {
		Connection connexion = null;
		PreparedStatement checkedStatement = null;
		ResultSet result = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			// Verifie si le mail est deja utilise
			checkedStatement = connexion.prepareStatement("SELECT * FROM produit where nom = ?");
			checkedStatement.setString(1, p.getNom());
			result = checkedStatement.executeQuery();
			if (result.next()) throw new DAOException("Produit deja dans la base de donnees");
			else {
				if (p.getUrl().equals("")) {
					preparedStatement = connexion.prepareStatement("INSERT INTO produit VALUES (DEFAULT, ?, ?, ?, ?, DEFAULT)");
					preparedStatement.setString(1, p.getNom());
					preparedStatement.setBigDecimal(2, p.getPrix());
					preparedStatement.setInt(3, p.getQuantite()); 
					preparedStatement.setString(4, p.getDescription());
					preparedStatement.executeUpdate();
				} else {
					preparedStatement = connexion.prepareStatement("INSERT INTO produit VALUES (DEFAULT, ?, ?, ?, ?, ?)");
					preparedStatement.setString(1, p.getNom());
					preparedStatement.setBigDecimal(2, p.getPrix());
					preparedStatement.setInt(3, p.getQuantite()); 
					preparedStatement.setString(4, p.getDescription());
					preparedStatement.setString(5, p.getUrl());
					preparedStatement.executeUpdate();
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de donnees");			
		}		
	}
	
	// Modifie le prix du produit
	public void updatePrixProduit(BigDecimal prix,int id) throws DAOException{
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();	
			preparedStatement = connexion.prepareStatement("UPDATE produit SET prix = ? WHERE idproduit = ?");
			preparedStatement.setBigDecimal(1, prix);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();		
		} catch(SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de donnees");
		}
	}
	
	// Modifie le stock du produit
	public void updateStockProduit(int quantite,int id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();	
			preparedStatement = connexion.prepareStatement("UPDATE produit SET quantite = ? WHERE idproduit = ?");
			preparedStatement.setInt(1, quantite);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();	
		} catch(SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de donnees");
		}
	}
	
	// Supprime un produit
	public void removeProduit(int id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();	
			preparedStatement = connexion.prepareStatement("DELETE FROM produit WHERE idproduit = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de donnees");
		}	
	}
	
	// Renvoie la liste des utilisateurs
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
				int id = result.getInt("idclient");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String mail = result.getString("mail");
				byte passerCommande = result.getByte("passer_commande");
				byte payerCommande = result.getByte("payer_commande");
				
				User user = new User();
				user.setIdclient(id);
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
	
	// Inscription : ajoute un utilisateur
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
				preparedStatement = connexion.prepareStatement("INSERT INTO user VALUES (DEFAULT, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, ?)");
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
	
	// Connexion
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
	
	// Supprime un utilisateur
	public void removeUser(int id) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();	
			preparedStatement = connexion.prepareStatement("DELETE FROM user WHERE idclient = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
	}
	
	// Modifie les droits d'utilisateur
	public void UpdateDroits(int id, int passerCommande, int payerCommande) throws DAOException{
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();	
			preparedStatement = connexion.prepareStatement("UPDATE user SET passer_commande = ?, payer_commande = ? WHERE idclient = ?");
			preparedStatement.setInt(1, passerCommande);
			preparedStatement.setInt(2, payerCommande);
			preparedStatement.setInt(3, id);
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
	}
	
	// Renvoie la cb avec les champs donnes
	public Cb getCb(String nom, Long num, String date, int cvv) throws DAOException {
		Cb card = null;
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("SELECT * FROM cb WHERE num = ? AND nom = ? AND date = ? AND cryptogramme = ?");
			preparedStatement.setLong(1, num);
			preparedStatement.setString(2, nom);
			preparedStatement.setString(3, date);
			preparedStatement.setInt(4, cvv);
			result = preparedStatement.executeQuery();
			
			if (result.next()) {
				result.first();
				card = new Cb();
				card.setNum(result.getLong("num"));
				card.setNom(result.getString("nom"));
				card.setDate(result.getString("date"));
				card.setCryptogramme(result.getInt("cryptogramme"));
				card.setSolde(result.getBigDecimal("solde"));
			}
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
		
		return card;
	}
	
	// Maj du solde du cb donne
	public void updateCbSolde(Cb cb) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE cb SET solde = ? WHERE num = ?");
			preparedStatement.setBigDecimal(1, cb.getSolde());
			preparedStatement.setLong(2, cb.getNum());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
	}
	
	// Maj du stock du produit donne
	public void updateProduitQuantite(Produit p) throws DAOException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE produit SET quantite = ? WHERE nom = ?");
			preparedStatement.setInt(1, p.getQuantite());
			preparedStatement.setString(2, p.getNom());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Impossible de communiquer avec la base de données");
		}
	}
}
