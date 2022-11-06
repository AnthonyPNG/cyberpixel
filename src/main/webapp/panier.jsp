<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	<%@include file="/style.css"%>
</style>

<div>
	<h2>Panier</h2>
	<c:choose>
		<c:when test="${not empty errPanier}">
			<c:out value="${errPanier}"/>
		</c:when>
		
		<c:when test="${not empty connecte}">
			<c:out value="passer commande : ${connecte.passerCommande}" />
			<c:out value="payer commande : ${connecte.payerCommande}" />
			<c:choose>
				<c:when test="${connecte.passerCommande == 0}">
					<p>Vous ne pouvez pas passer de commandes.</p>
				</c:when>
				
				<c:when test="${empty paniers}">
					<p><c:out value="Votre panier est vide" /></p>
				</c:when>
							
				<c:otherwise>
					<c:forEach items="${paniers.articles}" var="panier">
						<span><c:out value="${panier.nom}" /></span>
						<p><c:out value="${panier.prix}€" /></p>
						<p><c:out value="${panier.quantite}" /></p>
						
						<form method="post" action="Panier">
							<button name="ajouterProd" value="${panier.idproduit}">AJOUTER</button>
							<button name="retirerProd" value="${panier.idproduit}">RETIRER</button>
							<button name="supprimerProd" value="${panier.idproduit}">❌</button>
						</form>
					</c:forEach>
					<p><c:out value="Total à payer : ${prixTotal}€" /></p>
					
					<c:choose>
						<c:when test="${connecte.payerCommande == 0}">
							<button disabled>PAYER</button>
						</c:when>
						
						<c:otherwise>
							<a class="hero-btn" href="/Projet-JEE/paiement">PAYER</a>
						</c:otherwise>
					</c:choose>					
				</c:otherwise>
			</c:choose>
		</c:when>
		
		<c:otherwise>
			<p>Vous devez vous <span>connecter</span> pour avoir accès à votre panier !</p>
			<a class="hero-btn" href="/Projet-JEE/connexion">SE CONNECTER</a>
		</c:otherwise>
	</c:choose>
</div>