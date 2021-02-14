<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion Administrateur</title>
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
	<form method="post" action="connexionadmin">
        <fieldset>
            <legend>Connexion administrateur</legend>
            <p>
 <label for="email">email: <span class="requis">*</span></label>
            <input type="email" id="email" name="email" placeholder="email" value="<c:out
value="${patient.email}"/>" size="20" maxlength="60" pattern="^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" required />
			</p><p>
			<label for="password">Mot de passe<span class="requis">*</span></label>
            <input type="password" id="password" name="password" placeholder="mot de passe" value="" size="20" maxlength="20" />
            </p>
             <input type="submit"/>
		</fieldset>
	</form>
</body>
</html>