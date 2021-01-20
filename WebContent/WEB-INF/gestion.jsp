<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Cas</title>
</head>
<main>
<table>
<caption>List of cas</caption>
<thead>
<tr>
<!-- 	<th>Id</th> -->
	<th>Nom</th>
	<th>Telephone</th>
	<th>Adresse</th>
	<th>Code Postal</th>
	<th>Etat</th>
	
</tr>
</thead>

<tbody>

	
<c:forEach var="cas" items="${list}">
<tr>
<%-- 		<th>${cas.id_cas}</th> --%>
		
		<td>${cas.nom_complet}</td>
		<td>${cas.telephone}</td>
		<td>${cas.adresse}</td>
		<td>${cas.code_postale}</td>
		<td>${cas.etat}</td>
		<td>
		<c:url value="Details" var="lienDetails">
		<c:param value="${cas.id_database}" name="id_database"></c:param>
		</c:url>
		<a href="${lienDetails}">Details cas</a>
		</td>
<!-- 		<td> -->
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${prod.getClass().name.equals('modeles.Boisson18')}"> --%>
<%-- 				${prod.pourcentageAlcool} --%>
<%-- 				</c:when> --%>
<%-- 	  			<c:otherwise> --%>
<%-- 	  			</c:otherwise> --%>
<%-- 			</c:choose>	 --%>
<!-- 		</td> -->
		

<!-- 		<td> -->
<%-- 			<c:url value="/Ajout" var="lienAjout">		 --%>
<%-- 			<c:param value="modif" name="what"></c:param> --%>
<%-- 			<c:param value="${prod.id }" name="id"></c:param> --%>
<%-- 			<c:param value="form" name="where"></c:param> --%>
<%-- 			</c:url> --%>
<%-- 			<a href="${lienAjout }">Modifier</a></td> --%>
		
<!-- 		<td> -->
<%-- 		<c:url value="/Suppression" var="lienSuppr"> --%>
<%-- 		<c:param value="${prod.id}" name="id"></c:param> --%>
<%-- 		</c:url> --%>
<%-- 		<a href="${lienSuppr }">Supprimer</a></td> --%>
	</tr>
</c:forEach>
</tbody>
</table>
<div>
<c:url value="/AjoutCas" var="lienAjout">		

<c:param value="link" name="action"></c:param>

</c:url>
		<a href="${lienAjout}">Ajouter</a>
</div>



</main>
</html>