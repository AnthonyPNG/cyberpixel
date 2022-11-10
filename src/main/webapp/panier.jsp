<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="preconnect" href="https://fonts.gstatic.com">
<style>
	<%@include file="/style.css"%>
</style>

<div class="jtt" style="width: 25%; float:right; height: 700px; background-color: #8558C2;">
	<h2>Panier</h2>
	<c:choose>
		<c:when test="${not empty errPanier}">
			<c:out value="${errPanier}"/>
		</c:when>
		
		<c:when test="${not empty connecte}">
			<c:choose>
				<c:when test="${connecte.passerCommande == 0}">
					<p>Vous ne pouvez pas passer de commandes.</p>
				</c:when>
				
				<c:when test="${empty paniers}">
					<p><c:out value="Votre panier est vide" /></p>
				</c:when>
							
				<c:otherwise>
					<c:forEach items="${paniers.articles}" var="panier">
						<div class="cart-product-card">
						<span><c:out value="${panier.nom}" /></span>
						<p><c:out value="${panier.prix}€" /></p>
						<p><c:out value="${panier.quantite}" /></p>
						
						<form method="post" action="Panier">
							<button class="product-cardbtn" name="ajouterProd" value="${panier.idproduit}">AJOUTER</button>
							<button class="product-cardbtn" name="retirerProd" value="${panier.idproduit}">RETIRER</button>
							<button class="product-cardbtnx" name="supprimerProd" value="${panier.idproduit}">❌</button>
						</form>
						</div>
					</c:forEach>
					
					<div>
						<p><c:out value="Total à payer : ${prixTotal}€" /></p>					
						<c:choose>
							<c:when test="${connecte.payerCommande == 0}">
								<button class="payer-btn" disabled>PAYER</button>
							</c:when>
							
							<c:otherwise>
								<a class="payer-btn" href="/Projet-JEE/paiement">PAYER</a>
							</c:otherwise>
						</c:choose>
					</div>				
				</c:otherwise>
			</c:choose>
		</c:when>
		
		<c:otherwise>
			<p>Vous devez vous <span>connecter</span> pour avoir accès à votre panier !</p>
			<a class="hero-btn" href="/Projet-JEE/connexion">SE CONNECTER</a>
		</c:otherwise>
	</c:choose>
</div>