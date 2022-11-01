<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<form get="post" action="">
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
				<button class="hero-btn" type="submit">SE CONNECTER</button>
				
				<div>
					<p>Vous avez déjà un compte ?</p>
					<a href="/Projet-JEE/connexion"><p>S'inscrire</p></a>
				</div>				
				
			</form>
		</div>
	</div>
</body>
</html>