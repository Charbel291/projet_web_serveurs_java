<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Patient</title>
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
<p style="font-style:italic;"><c:out value="${ client.email }"/></p>
<ul>
	<li> <a href="/projet/selectioncentre?client=<c:out value="${client.email}"/>"> Prise de rendez-vous </a></li>
	<li> <a href="/projet/mesrdvs?client=<c:out value="${client.email}"/>"> Mes rendez-vous </a></li>
	<li> <a href="/projet/accueil"> Deconnexion </a></li>
<!--	<li> <a href="#"> Suppression du compte </a></li>
		<li> <a href="/projet/"> Deconnexion </a></li>		-->
</ul>

  <h1><c:out value="${ client.nom }" /> <c:out value="${ client.prenom }" /> </h1>
  <br>
<form method="post" action="sessionpatient">
        <fieldset>
            <legend>Modification du compte</legend>
            <p>
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" placeholder="nom" value="<c:out value="${ client.nom }" />" size="20" maxlength="20" />
            </p><p>
            <label for="prenom">Prenom:</label>
            <input type="text" id="prenom" name="prenom" placeholder="prenom" value="<c:out value="${client.prenom}" />" size="20" maxlength="100" />
            </p><p>
            <label for="numero_tel">Tel:</label>
            <input type="tel" id="numero_tel" name="numero_tel" placeholder="numero_tel" value="<c:out value="${client.numero_tel}" />" size="20" maxlength="100" pattern="(0|\\+33|0033)[1-9][0-9]{8}" required />
            </p><p>
            <label for="annee_naissance">annee_naissance</label>
            <input type="text" id="annee_naissance" name="annee_naissance" placeholder="annee_naissance" value="<c:out value="${client.annee_naissance}" />" size="20" />
            </p><p>
            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" placeholder="adresse" value="<c:out value="${client.adresse}" />" size="20" maxlength="100" />
            </p><p>
            <label for="email">email: <span class="requis">*</span></label>
            <input type="email" id="email" name="email" placeholder="email" value="<c:out
value="${client.email}"/>" size="20" maxlength="60" pattern="^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" required />
			</p><p>
			<label for="password">Mot de passe<span class="requis">*</span></label>
            <input type="password" id="password" name="password" placeholder="mot de passe" value="<c:out value="${client.password}" />" size="20" maxlength="20" />
            </p><p>
            <!-- confirmation mot de passe -->
            <input type="submit"/>
            </p>
        </fieldset>
    </form>

</body>
</html>