<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Medecin</title>
<style>
html, body {
	height:100%;
	width:100%;
}

h1{
text-align:center;
}

</style>
</head>
<body>
<p style="font-style:italic;"><c:out value="${ medecin.email }"/></p>
<!-- <button id="planning">Prise de rendez-vous</button>  -->
<ul>
	<li> <a href="/projet/listerdvs?medecin=<c:out value="${medecin.email}"/>"> Mes rendez-vous </a></li>
	<li> <a href="/projet/accueil"> Deconnexion </a></li>	
</ul>

  <h1>Dr. <c:out value="${ medecin.prenom }" /> <c:out value="${ medecin.nom }" /> </h1>
  <br>
<form method="post" action="sessionmedecin">
        <fieldset>
            <legend>Modification du compte</legend>
            <p>
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" placeholder="nom" value="<c:out value="${ medecin.nom }" />" size="20" maxlength="20" />
            </p><p>
            <label for="prenom">Prenom:</label>
            <input type="text" id="prenom" name="prenom" placeholder="prenom" value="<c:out value="${medecin.prenom}" />" size="20" maxlength="100" />
            </p><p>
            <label for="numero_tel">Tel:</label>
            <input type="tel" id="numero_tel" name="numero_tel" placeholder="numero_tel" value="<c:out value="${medecin.numero_tel}" />" size="20" maxlength="100" pattern="(0|\\+33|0033)[1-9][0-9]{8}" required />
            </p><p>
            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" placeholder="adresse" value="<c:out value="${medecin.adresse}" />" size="20" maxlength="100" />
            </p><p>
            <label for="email">email: <span class="requis">*</span></label>
            <input type="email" id="email" name="email" placeholder="email" value="<c:out
value="${medecin.email}"/>" size="20" maxlength="60" pattern="^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" required />
			</p><p>
			<label for="password">Mot de passe<span class="requis">*</span></label>
            <input type="password" id="password" name="password" placeholder="mot de passe" value="<c:out
value="${medecin.password}"/>" size="20" maxlength="20" />
            </p><p>
            <!-- confirmation mot de passe -->
            <input type="submit"/>
            </p>
        </fieldset>
    </form>

</body>
</html>