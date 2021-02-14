<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AnnuaireMedecins</title>
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
<h2 style="color:white;font-weight:bold;text-align:center;">Annuaire Medical</h2>
<table>
	<tr>
		<th scope="col">Medecin</th>
        <th scope="col">Specialite</th>
        <th scope="col">Centre_Medical</th>
	</tr>
	<c:forEach var="medecin" items="${ annuaire }">
		<tr>
			<th scope="row"><c:out value="${ medecin.medecin_email }" /></th>
			<td><c:out value="${ medecin.specialite }" /></td>
			<td><c:out value="${ medecin.centre_medical }" /></td>
		</tr>
	</c:forEach>	
</table>
</body>
</html>