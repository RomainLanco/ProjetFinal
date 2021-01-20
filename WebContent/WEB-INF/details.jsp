<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ajout cas</title>
</head>
<body>
<h1>Ajout d'un cas</h1>


<div>
ID : <p>${id_database } </p>
</div>
<div>
Nom Prenom : <p>${nom}</p>
</div>
<div>
adresse : <p>${adresse}</p>
</div>
<div>
telephone : <p>${telephone} </p>
</div>
<div>
code postal : <p> ${code_postale}</p>
</div>
<div>
Etat : <p>${etat}</p>


<table>
<caption>List of cas</caption>
<thead>
<tr>
<!-- 	<th>Id</th> -->
	<th>jour</th>
	<th>mois</th>
	<th>annee</th>
	<th>resultat</th>
	
	
</tr>
</thead>

<tbody>
<c:forEach var="test" items="${listPcrCas}">
<tr>

		
		<td>${test.jour}</td>
		<td>${test.mois}</td>
		<td>${test.annee}</td>
		
				<td>
			<c:choose>
				<c:when test="${test.resultat=='1'}">
				Positif
				</c:when>
	  			<c:otherwise>Negatif
	  			</c:otherwise>
			</c:choose>	
		</td>
<%-- 		<td>${test.resultat}</td> --%>
		
		
</tr>
</c:forEach>
	</tbody>
	</table>
	
		
		
<c:url value="/AjoutTest" var="lienAjout">		
<c:param value="${id_database}" name="id_database"></c:param>
<c:param value="link" name="action"></c:param>

</c:url>

		<a href="${lienAjout}">Ajouter test PCR</a>
		
</div>




</body>
</html>