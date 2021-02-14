<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription du patient</title>
<link type="text/css" rel="stylesheet" href="/WEB-INF/form.css" />
    <style>
    
    body{
        background-color:rgb(241, 233, 241);
    }

    body, p, legend, label, input {
    	font: normal 8pt verdana, helvetica, sans-serif;
	}


	fieldset{
    	padding: 10px;
    	border: 1px #0568CD solid;
	}

	form label {
    	float: left;
    	width: 200px;
    	margin: 3px 0px 0px 0px;
    }
    
    legend{
        font-weight: bold;
        color: #0568CD;
    }

    form input{
        margin: 3px 3px 0px 0px;
        border: 1px rgb(83, 25, 25) solid;
    }

    form input.sansLabel{
        margin-left: 200px; 
    }

    form .requis{
        color: #c00;
    }
    </style>
</head>
<body>
    
    <form method="post" action="inscriptionpatient">
        <fieldset>
            <legend>Inscription du patient</legend>
            <p>
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" placeholder="nom" value="<c:out value="${patient.nom}" />" size="20" maxlength="20" />
            </p><p>
            <label for="prenom">Prenom:</label>
            <input type="text" id="prenom" name="prenom" placeholder="prenom" value="<c:out value="${patient.prenom}" />" size="20" maxlength="100" />
            </p><p>
            <label for="numero_tel">Tel:</label>
            <input type="tel" id="numero_tel" name="numero_tel" placeholder="numero_tel" value="<c:out value="${patient.numero_tel}" />" size="20" maxlength="100" pattern="(0|\\+33|0033)[1-9][0-9]{8}" required />
            </p><p>
            <label for="annee_naissance">annee_naissance</label>
            <input type="text" id="annee_naissance" name="annee_naissance" placeholder="annee_naissance" value="<c:out value="${patient.annee_naissance}" />" size="20" />
            </p><p>
            <label for="adresse">Adresse:</label>
            <input type="text" id="adresse" name="adresse" placeholder="adresse" value="<c:out value="${patient.adresse}" />" size="20" maxlength="100" />
            </p><p>
            <label for="email">email: <span class="requis">*</span></label>
            <input type="email" id="email" name="email" placeholder="email" value="<c:out
value="${patient.email}"/>" size="20" maxlength="60" pattern="^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" required />
			</p><p>
			<label for="password">Mot de passe<span class="requis">*</span></label>
            <input type="password" id="password" name="password" placeholder="mot de passe" value="" size="20" maxlength="20" />
            </p><p>
            <!-- confirmation mot de passe -->
            <input type="submit"/>
            </p>
        </fieldset>
    </form>
</body>
</html>