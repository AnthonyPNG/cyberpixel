<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Clients</title>
	<style>
		<%@include file="/style.css"%>
	</style>
			
</head>

<body>
	<div class="header">
		<%@ include file="navbar.jsp" %>
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
								<tr>
									<td><p><c:out value="${client.nom}" /></p></td>
									<td><p><c:out value="${client.prenom}" /></p></td>
									<td><p><c:out value="${client.mail}" /></p></td>
									<c:choose>
										<c:when test="${client.passerCommande == 1}">
											<td>
												<label class="switch">
													<input type="checkbox" name="passerCmd" value="${client.idclient}" checked>
													<span class="slider round"></span>
												</label>
											</td>
										</c:when>
										
										<c:otherwise>
											<td>
												<label class="switch">
													<input type="checkbox" name="passerCmd" value="${client.idclient}">
													<span class="slider round"></span>
												</label>
											</td>
										</c:otherwise>
									</c:choose>
									
									<c:choose>
										<c:when test="${client.payerCommande == 1}">
											<td>
												<label class="switch">
													<input type="checkbox" name="payerCmd" value="${client.idclient}" checked>
													<span class="slider round"></span>
												</label>
											</td>
										</c:when>
										
										<c:otherwise>
											<td>
												<label class="switch">
													<input type="checkbox" name="payerCmd" value="${client.idclient}">
													<span class="slider round"></span>
												</label>
											</td>
										</c:otherwise>
									</c:choose>
									
									<td>
										<button class="client-btn"name="supprimerUser" value="${client.idclient}">
	    									<spane>CONFIRMER SUPPRESSION</spane>
	    									<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
	        									<path stroke-linecap="round" stroke-linejoin="round" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
	   										</svg>
										</button>
	 	 							</td>
								</tr>								
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>