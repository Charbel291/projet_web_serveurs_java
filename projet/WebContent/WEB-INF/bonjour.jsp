<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

input {
  width: 250px;
  padding: 12px 20px;
  margin: 8px 0;
  display: block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

form {
	height:100%;
	margin:0;
	width:100%;
}

</style>
</head>
<body>

<p style="font-style:italic;"><c:out value="${ admin }"/></p>
<a href="/projet/accueil"> Deconnexion </a>
<p style="text-decoration:underline; text-align:center;">Liste des medecins</p>
	<br><br>
	<table>
		<tr>
			<th scope="col">Email</th>
        	<th scope="col">Nom</th>
        	<th scope="col">Prenom</th>
        	<th scope="col">Adresse</th>
        	<th scope="col">Numero_Tel</th>
        	<th scope="col">Password</th>
		</tr>
		<c:forEach var="user" items="${ utilisateurs }">
			<tr>
				<th scope="row"><c:out value="${ user.email }" /></th>
				<td><c:out value="${ user.nom }" /></td>
				<td><c:out value="${ user.prenom }" /></td>
				<td><c:out value="${ user.adresse }" /></td>
				<td><c:out value="${ user.numero_tel }" /></td>
				<td><c:out value="${ user.password }" /></td>
			</tr>
		</c:forEach>	
	</table>
	
	<br>

<h1 style="left:20px;">Ajouter un medecin</h1>
	
	<br><br>
	<form style="left:20px;" method="post" action="bonjour">
		<p>
	<!--  <label for="email">Email : </label> -->		
			<input type="text" id="email" name="email" placeholder="email" pattern="^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" required />
		</p>
		<p>
			<input type="text" id="nom" name="nom" placeholder="nom" required />
		</p>
		<p>
			<input type="text" id="prenom" name="prenom" placeholder="prenom" required />
		</p>
		<p>
			<input type="text" id="adresse" name="adresse" placeholder="adresse" required />
		</p>
		<p>
			<input type="text" id="numero_tel" name="numero_tel" placeholder="numero" required />
		</p>
		<p>
			<input type="text" id="password" name="password" placeholder="mot de passe" required />
		</p>	
		<input type="submit" />
	</form>

<!--  -->	

<!--  -->
	<!--  
	<ul>
		<c:forEach var="utilisateur" items="${ utilisateurs }">
			<li><c:out value="${ utilisateur.email }" /> <c:out value="${ utilisateur.nom }" /> <c:out value="${ utilisateur.prenom }" /> <c:out value="${ utilisateur.numero_tel }" /> <c:out value="${ utilisateur.adresse }" /> <c:out value="${ utilisateur.password }" /></li>
		</c:forEach>
	</ul>
	-->

	
	
	
<!-- 
<p> Bonjour ${ medecin.prenom } ${ medecin.nom } </p>
<p><c:out value="Bonjour !" /></p>
 -->
 
 	<script type="text/javascript">
 		var email = document.getElementById("email");
 		
 	</script>

</body>
</html>