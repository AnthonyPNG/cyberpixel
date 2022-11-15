<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Commandes</title>
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
					<c:when test="${not empty errCommande}">
						<c:out value="${errCommande}" />
					</c:when>
						
					<c:when test="${empty commandes}">
						<span>La liste des commandes est vide !</span>
					</c:when>
						
					<c:otherwise>
						<div class="tbl-header">
						<table cellpadding="0" cellspacing="0" border="0">
							<thead>
								<tr>
									<th><h2>Email</h2></th>
									<th><h2>Date</h2></th>
									<th><h2>Prix</h2></th>
								</tr>
							</thead>
						</table>
						</div>
						
						<div class="tbl-content">
							<table cellpadding="0" cellspacing="0" border="0">
								<tbody>
									<c:forEach items="${commandes}" var="commande">
										<tr>
											<td><p><c:out value="${commande.mail}" /></p></td>
											<td><p><c:out value="${commande.date}" /></p></td>
											<td><p><c:out value="${commande.prix}€" /></p></td>
										</tr>							
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
			</c:when>
			
			<c:otherwise>
				<c:choose>
					<c:when test="${not empty errCommande}">
						<c:out value="${errCommande}" />
					</c:when>
						
					<c:when test="${empty commandes}">
						<span>La liste des commandes est vide !</span>
					</c:when>
						
					<c:otherwise>
						<div class="tbl-header">
						<table cellpadding="0" cellspacing="0" border="0">
							<thead>
								<tr>
									<th><h2>Date</h2></th>
									<th><h2>Prix</h2></th>
								</tr>
							</thead>
						</table>
						</div>
						
						<div class="tbl-content">
							<table cellpadding="0" cellspacing="0" border="0">
								<tbody>
									<c:forEach items="${commandes}" var="commande">
										<tr>
											<td><p><c:out value="${commande.date}" /></p></td>
											<td><p><c:out value="${commande.prix}€" /></p></td>
										</tr>							
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>	
	</div>
</body>
</html>