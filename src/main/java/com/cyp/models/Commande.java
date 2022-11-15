package com.cyp.models;

import java.math.BigDecimal;
import java.sql.Date;

public class Commande implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idcommande;
	private String mail;
	private BigDecimal prix;
	private Date date;

	public Commande() {
	}

	public Commande(String mail, BigDecimal prix, Date date) {
		this.mail = mail;
		this.prix = prix;
		this.setDate(date);
	}

	public Integer getIdcommande() {
		return this.idcommande;
	}

	public void setIdcommande(Integer idcommande) {
		this.idcommande = idcommande;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}