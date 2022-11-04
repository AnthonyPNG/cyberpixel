<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>S'inscrire</title>
</head>

<body>
	<div class="header">
		<%@ include file="navbar.jsp" %>
		<h1>S'INSCRIRE</h1>
		
		<div>
			<c:if test="${not empty errInscription}">
				<p><c:out value="${errInscription}" /></p>
			</c:if>
			<form method="post" action="Inscription">
				<p>Nom</p>
				<input type="text" name="nom" />
				
				<p>Prénom</p>
				<input type="text" name="prenom" />
				
				<p>Adresse</p>
				<input type="text" name="adresse" />
				
				<p>Mail</p>
				<input type="email" name="mail" />
				
				<p>Mot de passe</p>
				<input type="password" name="mdp1" />
				
				<p>Confirmer votre mot de passe</p>
				<input type="password" name="mdp2" />
				
				</br>
				<button class="hero-btn" type="submit">S'INSCRIRE</button>
				
				<div>
					<p>Vous avez déjà un compte ?</p>
					<a href="/Projet-JEE/connexion"><p>Se connecter</p></a>
				</div>				
				
			</form>
		</div>
	</div>
</body>
</html>