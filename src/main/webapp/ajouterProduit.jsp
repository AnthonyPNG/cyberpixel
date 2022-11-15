<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ajouter un produit</title>
	<link rel="shortcut icon" type="png" href="https://cdn.discordapp.com/attachments/1031949427960725555/1039553476449030174/logo.png"/>
	<style>
		<%@include file="/style.css"%>
	</style>
</head>

<body>
	<section class="header">
	<%@ include file="navbar.jsp" %>
	
	<c:choose>
		<c:when test="${connecte.role == 'admin'}">
			<div class="ajout-box">
				<div class="signup-form">		
					<form method="post" action="AjouterProduit">
						<h1>AJOUTER UN PRODUIT</h1>
					
						<c:if test="${not empty errAjoutProduit}">
							<p><c:out value="${errAjoutProduit}" /></p>
						</c:if>
						
						<div class="form-group">
							<input type="text" class="form-control" name="nom" placeholder="Nom" required="required">
						</div>
						
						<div class="form-group">
							<input type="text" class="form-control" name="description" placeholder="Description">
						</div>
						
						<div class="form-group">
							<input type="number" step="0.01" class="form-control" name="prix" placeholder="Prix" required="required">
						</div>
						
						<div class="form-group">
							<input type="number" class="form-control" name="quantite" placeholder="Quantite" required="required">
						</div>
						
						<div class="form-group">
							<input type="text" class="form-control" name="url" placeholder="URL de l'image">
						</div>
						
						<div class="form-group">
							<button type="submit" class="btn btn-secondary btn-sm btn-block">AJOUTER</button>
						</div>
					</form>			
				</div>	
			</div>
		</c:when>
		
		<c:otherwise>
			<div class="text-box">
				<h1>Oups...</h1>
				<h3>Vous ne pouvez pas accéder à cette page</h3>
				<a class="hero-btn" href="/Projet-JEE/">RETOUR A L'ACCUEIL</a>
			</div>
		</c:otherwise>
	</c:choose>	
	</section>
</body>
</html>