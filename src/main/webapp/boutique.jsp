<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Boutique</title>
</head>

<body>
	<div class="header">
		<%@ include file="navbar.jsp" %>
		<h1>BOUTIQUE</h1>
		
		<c:choose>
			<c:when test="${not empty erreur}">
				<c:out value="${erreur}"></c:out>
			</c:when>
			
			<c:otherwise>
				<c:forEach items="${produits}" var="prod">
					<div>
						<span><c:out value="${prod.nom}" /></span>
						<img alt="${prod.nom}" src="${prod.url}">
						<p><c:out value="${prod.description}" /></p>
						<p><c:out value="${prod.prix}€" /></p>
						<p><c:out value="${prod.quantite}" /></p>
						
						<c:choose>
							<c:when test="${not empty connecte}">
								<form method="get" action="Panier">
									<button name="ajouterProd" value="${prod.idproduit}">AJOUTER AU PANIER</button>
								</form>
							</c:when>
							
							<c:otherwise>
								<button disabled>AJOUTER AU PANIER</button>								
							</c:otherwise>
						</c:choose>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<%@ include file="panier.jsp" %>
	</div>
</body>
</html>