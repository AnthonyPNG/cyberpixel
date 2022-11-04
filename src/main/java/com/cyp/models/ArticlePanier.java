package com.cyp.models;

public class ArticlePanier {
	public Produit produit;
	public int quantite;
	
	public ArticlePanier(Produit produit) {
		this.produit = produit;
		this.quantite = 1;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
}
