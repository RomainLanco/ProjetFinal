<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ajout test PCR</title>
</head>
<body>
<h1>Ajout d'un test PCR</h1>

<div><font color="red">${error}</font></div>
<form action="AjoutTest" method="post">
<div>
Id :<input type="text" name="id_database" value="${id_database}" readonly>
</div>
<div>
<label for="start">Test PCR date:</label>

<input type="date" id="start" name="dateTest"
       value="2019-01-01"
       min="2018-01-01" max="2030-12-31">
</div>
<div>Resultat:
<select name="resultat">
<option value="1">positif</option>
<option value="-1">negatif</option>
</select>
</div>

<input type="hidden" name="action" value="ajouter">



<button type="submit"> Ajouter </button>
</form>
</body>
</html>