<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	<%@include file="/style.css"%>
</style>

<div>
	<h2>Panier</h2>
	<c:choose>
		<c:when test="${not empty errPanier}">
			<c:out value="${errPanier}"/>
		</c:when>
		
		<c:when test="${not empty connecte}">
			<c:choose>
				<c:when test="${empty articles}">
					<p><c:out value="Votre panier est vide" /></p>
				</c:when>
				
				<c:otherwise>
					<c:forEach items="${articles.items}" var="item">
						<c:out value="${item}"></c:out>
					</c:forEach>
					<c:out value="Prix total : ${articles.prixTotal}"></c:out>				
				</c:otherwise>
			</c:choose>
		</c:when>
		
		<c:otherwise>
			<span>Vous devez vous <p>connecter</p> pour avoir accès à votre panier !</span>
			<button>SE CONNECTER</button>
		</c:otherwise>
	</c:choose>
</div>