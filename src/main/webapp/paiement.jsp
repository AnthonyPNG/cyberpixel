<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Paiement</title>
	<style>		
		* {
		  box-sizing: border-box;
		}
		
		.row {
		  display: -ms-flexbox; /* IE10 */
		  display: flex;
		  -ms-flex-wrap: wrap; /* IE10 */
		  flex-wrap: wrap;
		  margin: 0 -16px;
		}
		
		.col-25 {
		  -ms-flex: 25%; /* IE10 */
		  flex: 25%;
		}
		
		.col-50 {
		  -ms-flex: 50%; /* IE10 */
		  flex: 50%;
		}
		
		.col-75 {
		  -ms-flex: 75%; /* IE10 */
		  flex: 75%;
		}
		
		.col-25,
		.col-50,
		.col-75 {
		  padding: 0 16px;
		}
		
		.container {
		  background-color: #f2f2f2;
		  padding: 5px 20px 15px 20px;
		  border: 1px solid lightgrey;
		  border-radius: 3px;
		}
		
		input[type=text] {
		  width: 100%;
		  margin-bottom: 20px;
		  padding: 12px;
		  border: 1px solid #ccc;
		  border-radius: 3px;
		}
		
		label {
		  margin-bottom: 10px;
		  display: block;
		}
		
		.icon-container {
		  margin-bottom: 20px;
		  padding: 7px 0;
		  font-size: 24px;
		}
		
		.btn {
		  background-color: #04AA6D;
		  color: white;
		  padding: 12px;
		  margin: 10px 0;
		  border: none;
		  width: 100%;
		  border-radius: 3px;
		  cursor: pointer;
		  font-size: 17px;
		}
		
		.btn:hover {
		  background-color: #45a049;
		}
		
		a {
		  color: #2196F3;
		}
		
		hr {
		  border: 1px solid lightgrey;
		}
		
		span.price {
		  float: right;
		  color: grey;
		}
		
		/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
		@media (max-width: 800px) {
		  .row {
		    flex-direction: column-reverse;
		  }
		  .col-25 {
		    margin-bottom: 20px;
		  }
		}
	</style>
</head>

<body>
	<div class="header">
		<div class="text-box">
				
			<div class="row">
			  <div class="col-75">
			    <div class="container">
			      <form method="post" action="Paiement">			
			          <div class="col-50">
			            <h1>Paiement en ligne</h1>
			            <div class="icon-container">
			              <i class="fa fa-cc-visa" style="color:navy;"></i>
			              <i class="fa fa-cc-amex" style="color:blue;"></i>
			              <i class="fa fa-cc-mastercard" style="color:red;"></i>
			              <i class="fa fa-cc-discover" style="color:orange;"></i>
			            </div>
			            <c:if test="${not empty errPaiement}">
			            	<c:out value="${errPaiement}" />
			            </c:if>
			            
			            <label for="nom">Nom sur la carte</label>
			            <input type="text" name="nom">
			            
			            <label for="num">N° de carte</label>
			            <input type="text" name="num">
			            
			            <div class="row">
			              <div class="col-50">
			                <label for="date">Date d'expiration</label>
			                <input type="text" name="date">
			              </div>
			              
			              <div class="col-50">
			                <label for="cvv">Cryptogramme visuel</label>
			                <input type="number" name="cvv">
			              </div>
			            </div>
			          </div>			          
			        </div>
			        
			        <input type="submit" name="action" value="Valider">
			        <input type="submit" name="action" value="Abandonner">
			      </form>
			    </div>
			  </div>
			  
			  <div class="col-25">
			    <div class="container">
			      <h4>Panier<span class="price" style="color:black"><i class="fa fa-shopping-cart"></i></span></h4>
			      <c:forEach items="${paniers.articles}" var="panier">
						<span><c:out value="${panier.nom}" /> <span class="price"><c:out value="${panier.prix * panier.quantite}€" /></span></span>
						<p><c:out value="${panier.prix}€ × ${panier.quantite}" /></p>
					</c:forEach>
			      <hr>
			      <p>Total <span class="price" style="color:black"><c:out value="${prixTotal}€" /></span></p>
			    </div>
			  </div>
			</div>
		</div>
	</div>
</body>
</html>