<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Se connecter</title>
</head>

<body>
	<div class="header">
		<%@ include file="navbar.jsp" %>
		<h1>SE CONNECTER</h1>
		
		<div>
			<c:if test="${not empty errConnexion}">
				<p><c:out value="${errConnexion}" /></p>
			</c:if>
			<form method="post" action="Connexion">
				<p>Mail</p>
				<input type="email" name="mail" />
				
				<p>Mot de passe</p>
				<input type="password" name="mdp" />
				
				</br>
				<button class="hero-btn" type="submit">SE CONNECTER</button>
				
				<div>
					<p>Mot de passe oublié</p>
					<a href="/Projet-JEE/inscription"><p>S'inscrire</p></a>
				</div>				
				
			</form>
		</div>
	</div>
</body>
</html>