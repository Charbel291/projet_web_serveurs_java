<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
  td,
th {
    border: 1px solid rgb(190, 190, 190);
    padding: 10px;
}

td {
    text-align: center;
}

tr:nth-child(even) {
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
    border: 2px solid rgb(200, 200, 200);
    letter-spacing: 1px;
    font-family: sans-serif;
    font-size: .8rem;
    margin: 0 auto;
}

</style>
</head>
<body>

<p><c:out value="${date}"/></p>

<p style="font-style:italic;"><c:out value="${ patient }"/></p>
<br>

<h1 style="text-align:center;">Veuillez indiquer vos preferences.</h1>
<br>
<form style="text-align:center;" method="post" action="planning">

<p>Choix du medecin dans le centre medical <c:out value="${ centre }"/></p>
<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="medecin" id="medecin">
	<c:forEach items="${ medecins }" var="choix">
		<option value="<c:out value="${ choix.email }"/>"><c:out value="${ choix.email }"/></option>
	</c:forEach>
</select>
<br>
<p>Choix de la date du rendez-vous </p>

<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="aaaa" id="aaaa">
  <option value="2021">2021</option>
  <option value="2022">2022</option>
</select>
<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="mm" id="mm">
  <option value="01">Janvier</option>
  <option value="02">Fevrier</option>
  <option value="03">Mars</option>
  <option value="94">Avril</option>
  <option value="05">Mai</option>
  <option value="06">Juin</option>
  <option value="07">Juillet</option>
  <option value="98">Aout</option>
  <option value="09">Septembre</option>
  <option value="10">Octobre</option>
  <option value="11">Novembre</option>
  <option value="12">Decembre</option>
</select>
<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="dd" id="dd">
  <option value="01">01</option>
  <option value="02">02</option>
  <option value="03">03</option>
  <option value="94">04</option>
  <option value="05">05</option>
  <option value="06">06</option>
  <option value="07">07</option>
  <option value="98">08</option>
  <option value="09">09</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
  <option value="26">26</option>
  <option value="27">27</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
</select>
<br><br>
<input id="client" name="client" value="<c:out value="${ patient }" />" placeholder="Veuillez renseigner votre email." pattern="^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$" readonly>
<br><br>
<input type="submit"/>

</form>
	
</body>
</html>