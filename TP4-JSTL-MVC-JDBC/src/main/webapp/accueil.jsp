<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Liste des contacts :</h1>
<table border="1">
<tr>
  <th>ID</th><th>Prénom</th><th>Nom</th><th>Email</th><th>Téléphone</th><th>Adresse</th>
</tr>
<c:forEach var="contact" items="${requestScope.listContacts}">
        <tr>
            <td>${contact.idContact}</td>
            <td>${contact.firstName}</td>
            <td>${contact.lastName}</td>
            <td>${contact.email}</td>
            <td>${contact.phone}</td>
            <td>${contact.address}</td>
            <td><a href="updateContact.jsp?contact_id=${contact.idContact}">Modifier</a></td>
        </tr>
</c:forEach>

</table>
<br/>
<a href="addContact.jsp">Créer un nouveau contact</a>
<a href="removeContact.jsp">Supprimer un contact</a>
</body>
</html>