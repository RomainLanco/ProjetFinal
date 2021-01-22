<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Covid</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
</head>
<body>
<form action="Authentification" method="post">
	<div class="mb-3"><label class="form-label">Login: </label><input class="form-control" type="text" name="login"/></div>
	<div class="mb-3"><label class="form-label">Password: </label><input class="form-control" type="text" name="password"/></div>
	<div class="mb-3"><p>${error}<p></div>
	<div><input class="btn btn-primary" type="submit" value="Valider..."/></div>
</form>
</body>
</html>