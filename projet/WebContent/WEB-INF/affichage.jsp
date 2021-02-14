<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  -->
<ul>
	<c:forEach var="rdv" items="${ rdvs }">
		<li> Bonjour <c:out value="${ rdv.medecin }" /> <c:out value="${ rdv.patient }" /> <c:out value="${ rdv.session }" /> </li>
	</c:forEach>
</ul>
<!--  -->
</body>
</html>
