<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Se connecter</title>
	<link rel="shortcut icon" type="png" href="https://cdn.discordapp.com/attachments/1031949427960725555/1039553476449030174/logo.png"/>
	<style>
		<%@include file="/style.css"%>
	</style>
</head>

<body>
	<section class="header">
	<%@ include file="navbar.jsp" %>
	<div class="text-box">
		<div class="signup-form">	
			<form method="post" action="Connexion">			
				<h1>SE CONNECTER</h1>
				<p class="hint-text">Connectez-vous à votre compte</p>
			
				<c:if test="${not empty errConnexion}">
					<p><c:out value="${errConnexion}" /></p>
				</c:if>
				
				<div class="form-group">
					<input type="email" class="form-control" name="mail" placeholder="Email" required="required" />
				</div>	
					
				<div class="form-group">
					<input type="password" class="form-control" name="mdp" placeholder="Mot de passe" required="required" />
				</div>
					
				<div class="form-group">
					<button type="submit" class="btn btn-secondary btn-sm btn-block">SE CONNECTER</button>
				</div>					
			</form>
				
			<div class="text-center">
				<p>
					Vous n'avez pas de compte ?
					<a href="/Projet-JEE/inscription">S'inscrire</a>
				</p>
			</div>	
		</div>
	</div>
	</section>
</body>
</html>