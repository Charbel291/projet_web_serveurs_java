<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selection Centre</title>
<style>
html, body {
	height:100%;
	width:100%;
}

h1{
font-weight:bold;
text-align:center;
}
</style>
</head>
<body>
<p style="font-style:italic;"><c:out value="${ patient }"/></p>
<br>
<h1>Veuillez selectionner le centre medical de votre choix.</h1>
<br>
<br>
<form style="text-align:center;" method="post" action="selectioncentre">
<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="centre" id="centre">
	<c:forEach items="${ centres }" var="choix">
		<option value="<c:out value="${ patient }"/>,<c:out value="${ choix }"/>"><c:out value="${ choix }"/></option>
	</c:forEach>
</select>
 <input type="submit"/>
</form>
</body>
</html>