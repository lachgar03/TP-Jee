<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Ajouter un contact</title></head>
<body>
<h2>Créer un contact :</h2>
<form action="ControllerServlet" method="post">
    <input type="hidden" name="do_this" value="create"/>
    Prénom: <input type="text" name="firstName"/><br/>
    Nom: <input type="text" name="lastName"/><br/>
    Email: <input type="text" name="email"/><br/>
    Téléphone: <input type="text" name="phone"/><br/>
    Adresse: <input type="text" name="address"/><br/>
    <input type="submit" value="Enregistrer"/>
</form>
</body>
</html>
