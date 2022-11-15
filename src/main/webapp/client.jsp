<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Clients</title>	
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="shortcut icon" type="png" href="https://cdn.discordapp.com/attachments/1031949427960725555/1039553476449030174/logo.png"/>
	<style>
		<%@include file="/style.css"%>
	</style>		
</head>

<body>
	<div class="header">
		<%@ include file="navbar.jsp" %>
		
		<c:choose>
			<c:when test="${connecte.role == 'admin'}">
				<h1>
					GERER CLIENTS
				</h1>
					
				<c:choose>
					<c:when test="${not empty errClient}">
						<c:out value="${errClient}" />
					</c:when>
						
					<c:when test="${empty clients}">
						<span>La liste des utilisateurs est vide !</span>
					</c:when>
						
					<c:otherwise>
						<div class="tbl-header">
						<table cellpadding="0" cellspacing="0" border="0">
							<thead>
								<tr>
									<th><h2>Nom</h2></th>
									<th><h2>Prenom</h2></th>
									<th><h2>Email</h2></th>
									<th><h2>Passer Commande</h2></th>
									<th><h2>Payer Commande</h2></th>
									<th></th>
								</tr>
							</thead>
						</table>
						</div>
						
						<div class="tbl-content">
							<table cellpadding="0" cellspacing="0" border="0">
								<tbody>
									<c:forEach items="${clients}" var="client">
										<form method="post" action="Client">
										<tr>
											<td><p><c:out value="${client.nom}" /></p></td>
											<td><p><c:out value="${client.prenom}" /></p></td>
											<td><p><c:out value="${client.mail}" /></p></td>
											<c:choose>
												<c:when test="${client.passerCommande == 1}">
													<td>
														<label class="switch">
															<input type="checkbox" name="passerCmd" value="${client.passerCommande}" checked onclick="if (this.checked) this.value='1'; else this.value='0';" >
															<span class="slider round"></span>
														</label>
													</td>
												</c:when>
												
												<c:otherwise>
													<td>
														<label class="switch">
															<input type="checkbox" name="passerCmd" value="${client.passerCommande}" onclick="if (this.checked) this.value='1'; else this.value='0';">
															<span class="slider round"></span>
														</label>
													</td>
												</c:otherwise>
											</c:choose>
											
											<c:choose>
												<c:when test="${client.payerCommande == 1}">
													<td>
														<label class="switch">
															<input type="checkbox" name="payerCmd" value="${client.payerCommande}" checked onclick="if (this.checked) this.value='1'; else this.value='0';">
															<span class="slider round"></span>
														</label>
													</td>
												</c:when>
												
												<c:otherwise>
													<td>
														<label class="switch">
															<input type="checkbox" name="payerCmd" value="${client.payerCommande}" onclick="if (this.checked) this.value='1'; else this.value='0';">
															<span class="slider round"></span>
														</label>
													</td>
												</c:otherwise>
											</c:choose>
											
											<td>
												<button class="client-btn-maj" name="majUser" value="${client.idclient}">
			    									<i class="material-icons w3-xlarge">done</i>
												</button>
												
												<button class="client-btn" name="supprimerUser" value="${client.idclient}">
			    									<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
			        									<path stroke-linecap="round" stroke-linejoin="round" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
			   										</svg>
												</button>
			 	 							</td>
										</tr>
										</form>								
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
			
			<c:otherwise>
				<div class="text-box">
					<h1>Oups...</h1>
					<h3>Vous ne pouvez pas accéder à cette page</h3>
					<a class="hero-btn" href="/Projet-JEE/">RETOUR A L'ACCUEIL</a>
				</div>
			</c:otherwise>
		</c:choose>	
	</div>
</body>
</html>