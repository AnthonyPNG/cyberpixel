package com.cyp.dao;

import java.util.List;

import org.hibernate.Session;

import com.cyp.models.Produit;
import com.cyp.models.User;

public class DAOBaseHibernate {
	//////////////////////////////////////// --- Boutique ---- ////////////////////////////////////////////////////////////////////////
	
	// Affiche les produits
	public static List<Produit> getListProduit() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<Produit> result = session.createQuery("from Produit").list();
		session.close();
		return result;
	}
	
	//////////////////////////////////////// --- User ---- ////////////////////////////////////////////////////////////////////////
	
	// Connexion
	// Retourne un user ou rien
	public static User connect(String mail, String mdp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> result = session.createQuery("from Etudiant where mail = " + mail + " and mdp = " + mdp).list();
		session.close();
		
		User user = null;
		if (result.isEmpty() == false) {
			user = result.get(0);
		}
		
		return user;
	}
	
	// Inscription
	public static void addUser(User u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
	}
		
	//////////////////////////////////////// --- Admin ---- ////////////////////////////////////////////////////////////////////////
	
	// Ajout un produit
	public static void addProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}
	
	// Affiche les clients
	public static List<User> getListUser() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> result = session.createQuery("from User where role = 'client'").list();
		session.close();
		return result;
	}
		

}
