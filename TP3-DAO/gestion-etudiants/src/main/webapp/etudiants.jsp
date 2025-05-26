<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="domain.Etudiant" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des étudiants</title>
</head>
<body>
<div>
    <form action="ajouter" method="get">
        Code: <input type="text" name="code" value="${etud.code}" /><br/>
        Nom: <input type="text" name="nom" value="${etud.nom}" /><br/>
        Ville: <input type="text" name="ville" value="${etud.ville}" /><br/>
        Age: <input type="text" name="age" value="${etud.age}" /><br/>
        <input type="submit" value="Ajouter" /><br/>
    </form>
</div>

<table border="1">
    <tr>
        <th>CODE</th>
        <th>NOM</th>
        <th>VILLE</th>
        <th>AGE</th>
        <th colspan="2">ACTIONS</th>
    </tr>
    <c:forEach items="${all}" var="e">
        <tr>
            <td><c:out value="${e.code}" /></td>
            <td><c:out value="${e.nom}" /></td>
            <td><c:out value="${e.ville}" /></td>
            <td><c:out value="${e.age}" /></td>
            <td><a href="supprimer?code=${e.code}">Supprimer</a></td>
            <td><a href="modifier?code=${e.code}">Modifier</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
