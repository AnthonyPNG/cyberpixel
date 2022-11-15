<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>S'inscrire</title>
	<link rel="shortcut icon" type="png" href="https://cdn.discordapp.com/attachments/1031949427960725555/1039553476449030174/logo.png"/>
	<style>
		<%@include file="/style.css"%>
	</style>
</head>

<body>
	<section class="header">
	<%@ include file="navbar.jsp" %>
	<div class="register-box">
		<div class="signup-form">		
			<form method="post" action="Inscription">
				<h1>S'INSCRIRE</h1>
				<p class="hint-text">Créez votre compte. C'est gratuit et cela ne prend qu'une minute</p>
			
				<c:if test="${not empty errInscription}">
					<p><c:out value="${errInscription}" /></p>
				</c:if>
				
				<div class="form-group">
					<input type="text" class="form-control" name="nom" placeholder="Nom" required="required">
				</div>
				
				<div class="form-group">
					<input type="text" class="form-control" name="prenom" placeholder="Prénom" required="required">
				</div>
				
				<div class="form-group">
					<input type="text" class="form-control" name="adresse" placeholder="Adresse" required="required">
				</div>
				
				<div class="form-group">
					<input type="email" class="form-control" name="mail" placeholder="Email" required="required">
				</div>
				
				<div class="form-group">
					<input type="password" class="form-control" name="mdp1" placeholder="Mot de passe" required="required">
				</div>
				
				<div class="form-group">
					<input type="password" class="form-control" name="mdp2" placeholder="Confirmez votre mot de passe" required="required">
				</div>
				
				<div class="form-group">
					<button type="submit" class="btn btn-secondary btn-sm btn-block">S'INSCRIRE</button>
				</div>
			</form>			
					
			<div class="text-center">
				<p>
					Vous avez déjà un compte? 
					<a href="/Projet-JEE/connexion">Se Connecter</a>
				</p>
			</div>
		</div>	
	</div>
	</section>
</body>
</html>