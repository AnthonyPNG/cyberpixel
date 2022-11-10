<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Boutique</title>
	<link rel="preconnect" href="https://fonts.gstatic.com">
</head>

<body>
	<section class="header">	
		<%@ include file="navbar.jsp" %>
		<h1>BOUTIQUE</h1>
	</section>
	
	<section class="actus">
		<div style="width:75%; float:left; height:700px; background-color:#8558C2;">
			<c:choose>
				<c:when test="${not empty erreur}">
					<c:out value="${erreur}"></c:out>
				</c:when>
				
				<c:otherwise>
					<c:forEach items="${produits}" var="prod">
							<div class="product-container">
								<div class="product-product-card">
									<div class="product-image">
										<img class="product-thumb" alt="${prod.nom}" src="${prod.url}">
										<c:choose>
											<c:when test="${not empty connecte}">
												<c:choose>								
													<c:when test="${connecte.passerCommande == 0}">
														<button class="product-card-btn" name="ajouterProd" value="${prod.idproduit}" disabled>AJOUTER AU PANIER</button>
													</c:when>
										
													<c:when test="${prod.quantite == 0}">
														<button class="product-card-btn" name="ajouterProd" value="${prod.idproduit}" disabled>AJOUTER AU PANIER</button>
													</c:when>
										
													<c:otherwise>																	
														<form method="get" action="Panier">
															<button class="product-card-btn" name="ajouterProd" value="${prod.idproduit}">AJOUTER AU PANIER</button>
														</form>								
													</c:otherwise>							
												</c:choose>
											</c:when>
								
											<c:otherwise>
												<button class="product-card-btn" disabled>AJOUTER AU PANIER</button>								
											</c:otherwise>
										</c:choose>
									</div>
									
									<div class="product-info">
										<span><c:out value="${prod.nom}" /></span>
										<p><c:out value="${prod.description}" /></p>
										<p><c:out value="${prod.prix}€" /></p>
										<p><c:out value="${prod.quantite}" /></p>
									</div>
								</div>
							</div>											
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		
		<%@ include file="panier.jsp" %>
	</section>
</body>
</html>