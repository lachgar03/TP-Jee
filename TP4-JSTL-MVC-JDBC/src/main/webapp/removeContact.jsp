<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Contact</title>
</head>
<body>
<h2>Supprimer un contact :</h2>
<form action="ControllerServlet" method="post">
    <input type="hidden" name="do_this" value="delete"/>
    ID du contact à supprimer : <input type="text" name="contact_id"/><br/>
    <input type="submit" value="Supprimer"/>
</form>
</body>
</html>



