<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Enregistrement d'un livre</h1>
<form action="LivreController" methode="Post">
<table>
<h2>Le Livre</h2>
<tr>
<td>Titre: </td>
<td><input type="text" name="titre"></td>
</tr>

<tr>
<td>Categorie: </td>
<td>
<select name="categorie">
	<option value="Roman">Roman</option>
	<option value="Policier">Policier</option>
	<option value="Junior">Junior</option>
	<option value="Philosophie">Philosophie</option>
	<option value="Sciences-fiction">Sciences-fiction</option>
</select>
</td>
</tr>

<tr>
<td>Le Numéro ISBN: </td>
<td><input type="number" name="isbn"></td>
</tr>
</table>
<h2>L'auteur</h2>
<table>
<tr>
<td>
Nom:
</td>
<td>
<input type="text" name="nom">
</td>
</tr>
<tr>
<td>
Prenom:
</td>
<td>
<input type="text" name="prenom">
</td>
</tr>

<tr>
<td><input type= "submit" value ="valider">
</tr>
</table>
</form>
</body>
</html>