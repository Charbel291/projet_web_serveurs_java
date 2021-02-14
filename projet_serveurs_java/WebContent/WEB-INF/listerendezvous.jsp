<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListeRendezVous</title>
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
<h2 style="color:white;font-weight:bold;text-align:center;">Liste des rendez-vous</h2>
<table>
	<tr>
		<th scope="col">Medecin</th>
        <th scope="col">Patient</th>
        <th scope="col">Session</th>
	</tr>
	<c:forEach var="rdv" items="${ listerdvs }">
		<tr>
			<th scope="row"><c:out value="${ rdv.medecin_email }" /></th>
			<td><c:out value="${ rdv.patient_email }" /></td>
			<td><c:out value="${ rdv.session }" /></td>
		</tr>
	</c:forEach>	
</table>
</body>
</html>