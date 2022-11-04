package com.cyp.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingPanier {
	public List<ArticlePanier> items;
	public double prixTotal;
	
	public ShoppingPanier() {
		items = new ArrayList<ArticlePanier>();
		prixTotal = 0;
	}
	
	public void ajouterProduit(Produit p) {
		boolean articlePresent = false;
		for (ArticlePanier item : items) {
			if (item.produit.getNom() == p.getNom()) {
				item.setQuantite(item.getQuantite()+1);
				articlePresent = true;
			}
		}
		
		if (!articlePresent) {
			items.add(new ArticlePanier(p));
		}
		this.setPrixTotal(this.getPrixTotal());
	}
	
	public void retirerProduit(Produit p) {
		for (ArticlePanier item : items) {
			if (item.produit.getNom() == p.getNom()) {
				item.setQuantite(item.getQuantite()-1);
				if (item.getQuantite() == 0) {
					items.remove(item);
				}
			}
		}
		this.setPrixTotal(this.getPrixTotal());
	}
	
	public void setPrixTotal(double prix) {
		this.prixTotal = prix;
	}
	
	public double getPrixTotal() {
		this.prixTotal = 0;
		for (ArticlePanier item : items) {
			this.prixTotal += item.produit.getPrix() * item.getQuantite();
		}
		return this.prixTotal;
	}
}
