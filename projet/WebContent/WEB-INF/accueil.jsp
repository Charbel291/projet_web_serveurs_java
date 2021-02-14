<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<br><br>
<h1 style="text-align:center;">Veuillez selectionner un profil.</h1>
<br>
<br>
<form style="text-align:center;" method="post" action="accueil">
<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="profil" id="profil">
		<option value="Administrateur"/>Administrateur</option>
		<option value="Medecin"/>Medecin</option>
		<option value="Patient"/>Patient</option>
</select>
<br><br>
 <input type="submit"/>
</form>
</body>
</html>