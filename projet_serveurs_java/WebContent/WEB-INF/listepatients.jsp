<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListePatients</title>
<style>
td,
th {
    border: 1px solid rgb(190, 190, 190);
    padding: 10px;
}

td {
    text-align: center;
}

tr {
    background-color: #eee;
}

th[scope="col"] {
    background-color: #696969;
    color: #fff;
}

th[scope="row"] {
    background-color: #d7d9f2;
}

table {
    border-collapse: collapse;
    border: 2px solid rgb(200, 200, 200);
    letter-spacing: 1px;
    font-family: sans-serif;
    font-size: .8rem;
}

</style>
</head>
<body style="background-color:teal;">
<h2 style="color:white;font-weight:bold;text-align:center;">Liste des patients</h2>
<table>
	<tr>
		<th scope="col">Email</th>
        <th scope="col">Nom</th>
        <th scope="col">Prenom</th>
        <th scope="col">Adresse</th>
        <th scope="col">Numero_Tel</th>
        <th scope="col">Annee_Naissance</th>
        <th scope="col">Password</th>
	</tr>
	<c:forEach var="user" items="${ utilisateurs }">
		<tr>
			<th scope="row"><c:out value="${ user.email }" /></th>
			<td><c:out value="${ user.nom }" /></td>
			<td><c:out value="${ user.prenom }" /></td>
			<td><c:out value="${ user.adresse }" /></td>
			<td><c:out value="${ user.numero_tel }" /></td>
			<td><c:out value="${ user.annee_naissance }" /></td>
			<td><c:out value="${ user.password }" /></td>
		</tr>
	</c:forEach>	
</table>
</body>
</html>