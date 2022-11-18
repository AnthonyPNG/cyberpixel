<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Produits</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="shortcut icon" type="png" href="https://cdn.discordapp.com/attachments/1031949427960725555/1039553476449030174/logo.png"/>
	<style>
		<%@include file="/style.css"%>
	</style>	
</head>

<body>
	<div class="header">
		<%@ include file="navbar.jsp" %>
		
		<c:choose>
			<c:when test="${connecte.role == 'admin'}">
				<h1>
					GERER PRODUITS
				</h1>
					
				<c:choose>
					<c:when test="${not empty errProduit}">
						<c:out value="${errProduits}" />
					</c:when>
						
					<c:when test="${empty produits}">
						<span>La liste des produits est vide !</span>
					</c:when>
						
					<c:otherwise>						
						<div class="tbl-header">
						<table cellpadding="0" cellspacing="0" border="0">
							<thead>
								<tr>
									<th><h2>Nom</h2></th>
									<th><h2>Description</h2></th>
									<th><h2>Prix</h2></th>
									<th><h2>Stock</h2></th>
									<th></th>
								</tr>
							</thead>
						</table>
						</div>
						
						<div class="tbl-content">
							<table cellpadding="0" cellspacing="0" border="0">
								<tbody>
									<c:forEach items="${produits}" var="produit">
										<form method="post" action="Produit">
										<tr>
											<td><p><c:out value="${produit.nom}" /></p></td>
											<td><p><c:out value="${produit.description}" /></p></td>
											<td class="form-group">
												<input type="number" step="0.01" class="form-control" name="prix" placeholder="${produit.prix}" />
											</td>
											<td class="form-group">
												<input type="number" class="form-control" name="quantite" placeholder="${produit.quantite}" />
											</td>
											
											<td>
												<button class="client-btn-maj" name="majProduit" value="${produit.idproduit}">
			    									<i class="material-icons w3-xlarge">done</i>
												</button>
												
												<button class="client-btn" name="supprimerProduit" value="${produit.idproduit}">
			    									<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
			        									<path stroke-linecap="round" stroke-linejoin="round" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
			   										</svg>
												</button>
			 	 							</td>
										</tr>
										</form>							
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
				
				<div class="btn-box">
					<p><a class="hero-btn" href="/Projet-JEE/ajouterProduit">AJOUTER UN PRODUIT</a></p>
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="text-box">
					<h1>Oups...</h1>
					<h3>Vous ne pouvez pas accéder à cette page</h3>
					<p><a class="hero-btn" href="/Projet-JEE/">RETOUR A L'ACCUEIL</a></p>
				</div>
			</c:otherwise>
		</c:choose>
		
	</div>
</body>
</html>