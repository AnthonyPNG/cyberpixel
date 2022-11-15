<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Paiement</title>
	<link rel="shortcut icon" type="png" href="https://cdn.discordapp.com/attachments/1031949427960725555/1039553476449030174/logo.png"/>
	<style>		
		* {
		  box-sizing: border-box;
		}
	
		<%@include file="/style.css"%>
	</style>
</head>

<body>
	<div class="header">
		<div class="box-size">
		<div class="text-box">				
			<div class="row">
			  <div class="col-75">
			    <div class="container">
			      <form method="post" action="Paiement">			
			      	<div class="col-50">
			      		<h1>Paiement en ligne</h1>
			            <p class="hint-text">Connectez-vous à votre compte</p>
			            
			            <c:if test="${not empty errPaiement}">
			            	<c:out value="${errPaiement}" />
			            </c:if>
			            
			            <div class="form-group">
							<input type="text" class="form-control" name="nom" placeholder="Nom sur la carte" />
						</div>
						
						<div class="form-group">
							<input type="number" class="form-control" name="num" placeholder="N° de carte" />
						</div>
						
						
						<div class="form-group">
							<input type="text" class="form-control" name="date" placeholder="Date d'expiration" />
						</div>
							
							
						<div class="form-group">
							<input type="number" class="form-control" name="cvv" placeholder="Cryptogramme visuel" />
						</div>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-secondary btn-sm btn-block"  name="action" value="Valider">VALIDER</button>
					</div>
					
					<div class="form-group">
						<button type="submit" class="btn btn-secondary btn-sm btn-block"  name="action" value="Abandonner">ABANDONNER</button>
					</div> 
			      </form>
			    </div>
			  </div>
			  
			  <div class="col-25">
			    <div class="container">
			      <h1>Panier</h1>
			      <c:forEach items="${paniers.articles}" var="panier">
						<span><c:out value="${panier.nom}" /> <span class="price"><c:out value="${panier.prix * panier.quantite}€" /></span></span>
						<p><c:out value="${panier.prix}€ × ${panier.quantite}" /></p>
					</c:forEach>
			      <hr>
			      <span>Total <p><c:out value="${prixTotal}€" /></p></span>
			    </div>
			  </div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>