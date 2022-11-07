<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	<%@include file="/style.css"%>
</style>

<div class="nav-links" id="navLinks">
	<c:choose>
		<c:when test="${not empty connecte}">
			<ul>
				<li><a href="/Projet-JEE/"><h2>ACCUEIL</h2></a></li>
				<li><a href="/Projet-JEE/boutique"><h2>BOUTIQUE</h2></a></li>
				<li><a href="/Projet-JEE/contact"><h2>CONTACT</h2></a></li>
				<li><a href="/Projet-JEE/deconnexion"><h2>SE DECONNECTER</h2></a></li>
			</ul>
		</c:when>
		<c:otherwise>
			<ul>
				<li><a href="/Projet-JEE/"><h2>ACCUEIL</h2></a></li>
				<li><a href="/Projet-JEE/boutique"><h2>BOUTIQUE</h2></a></li>
				<li><a href="/Projet-JEE/contact"><h2>CONTACT</h2></a></li>
				<li><a href="/Projet-JEE/connexion"><h2>SE CONNECTER</h2></a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</div>