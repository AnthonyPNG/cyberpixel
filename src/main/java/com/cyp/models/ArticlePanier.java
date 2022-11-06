package com.cyp.models;

import java.math.BigDecimal;

public class ArticlePanier {
	public Produit produit;
	public int idproduit;
	public String nom;
	public BigDecimal prix;
	public int quantite;
	
	public ArticlePanier(Produit produit) {
		this.produit = produit;
		this.idproduit = this.produit.getIdproduit();
		this.nom = this.produit.getNom();
		this.prix = this.produit.getPrix();
		this.quantite = 1;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public int getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}
	
}
