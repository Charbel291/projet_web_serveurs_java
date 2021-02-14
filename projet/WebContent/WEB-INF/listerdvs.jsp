<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

html, body {
	height:100%;
	width:100%;
}

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

caption {
    padding: 10px;
    caption-side: bottom;
}

table {
    border-collapse: collapse;
    border: 2px solid gold;
    letter-spacing: 1px;
    font-family: sans-serif;
    font-size: .8rem;
    margin: 0 auto;
}
</style>
<body>
<p style="font-style:italic;"><c:out value="${ medecin }"/></p>
<br>
<h1 style="text-align:center;">Mes rendez-vous</h1>
<br>
	<table>
		<tr>
			<th scope="col">Patient</th>
			<th scope="col">Creneau</th>
		</tr>
		<c:forEach var="rdv" items="${ rdvs }">
			<tr>
				<th scope="row"><c:out value="${ rdv.patient }" /></th>
				<td><c:out value="${ rdv.session }" /></td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>