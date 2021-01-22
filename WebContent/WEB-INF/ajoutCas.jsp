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
<div><font color="red">${error}</font></div>
<form action="AjoutCas" method="post">
<!-- <div> -->
<%-- Id :<input type="text" name="id" value="${nb_cas}"> --%>
<!-- </div> -->
<div>etat :
<select name="etat">
<option value="1">positif</option>
<option value="-1">negatif</option>
</select>
</div>
<div>
Nom Prenom :<input type="text" name="nom" value="">
</div>
<div>
adresse :<input type="text" name="adresse" value="">
</div>
<div>
telephone :<input type="text" name="telephone" value="">
</div>
<div>
code postal :<input type="text" pattern="[0-9]{4}" name="code_postale" value="" title="code postal 4 chiffres">

</div>
<input type="hidden" name="action" value="ajouter">



<button type="submit"> Ajouter </button>
</form>
</body>
</html>