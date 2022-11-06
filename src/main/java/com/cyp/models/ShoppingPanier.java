package com.cyp.models;

import java.util.ArrayList;
import java.util.List;

public class ShoppingPanier {
	private List<ArticlePanier> articles;
	
	public ShoppingPanier() {
		setArticles(new ArrayList<ArticlePanier>());
	}
	
	public List<ArticlePanier> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticlePanier> articles) {
		this.articles = articles;
	}
	
	public void ajouterProduit(Produit p) {
		boolean articlePresent = false;
		for (ArticlePanier article : getArticles()) {
			if (article.produit.getNom().equals(p.getNom())) {
				article.setQuantite(article.getQuantite()+1);
				articlePresent = true;
			}
		}
		
		if (!articlePresent) {
			getArticles().add(new ArticlePanier(p));
		}
	}
	
	public void retirerProduit(Produit p) {
		ArticlePanier a = null;
		for (ArticlePanier article : getArticles()) {
			if (article.produit.getNom().equals(p.getNom())) {
				article.setQuantite(article.getQuantite()-1);
				a = article;
				break;
			}
		}
		
		if (articles.get(articles.indexOf(a)).getQuantite() == 0) {
			articles.remove(a);
		}
	}

	public void supprimerProduit(Produit p) {
		ArticlePanier a = null;
		for (ArticlePanier article : getArticles()) {
			if (article.produit.getNom().equals(p.getNom())) {
				a = article;
				break;
			}
		}
		
		articles.remove(a);
	}
}
