<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<p style="font-style:italic;"><c:out value="${ patient }"/></p>
<br>
<p style="text-align:center; text-decoration: underline;">Liste des disponibilites du medecin <c:out value="${ medecin }" /> pour la date <c:out value="${ date }"/></p>
<br>
 <table>
		<tr>
			<th scope="col">Creneau</th>
			<th scope="col">Rdv</th>
		</tr>
		<tr>
			<th scope="row">08:00</th>
			<c:set var="dispo8" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '08:00'}">
    				<c:set var="dispo8" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo8}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo8}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">08:30</th>
			<c:set var="dispo830" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '08:30'}">
    				<c:set var="dispo830" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo830}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo830}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">09:00</th>
			
			<c:set var="dispo9" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '09:00'}">
    				<c:set var="dispo9" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo9}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo9}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">09:30</th>
			
			<c:set var="dispo930" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '09:30'}">
    				<c:set var="dispo930" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo930}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo930}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">10:00</th>
			<c:set var="dispo10" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '10:00'}">
    				<c:set var="dispo10" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo10}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo10}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">10:30</th>
			<c:set var="dispo1030" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '10:30'}">
    				<c:set var="dispo1030" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1030}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1030}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">11:00</th>
			<c:set var="dispo11" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '11:00'}">
    				<c:set var="dispo11" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo11}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo11}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr> 
		<tr>
			<th scope="row">11:30</th>
			<c:set var="dispo1130" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '11:30'}">
    				<c:set var="dispo1130" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1130}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1130}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">12:00</th>
			<c:set var="dispo12" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    			<c:if test = "${creneau == '12:00'}">
    				<c:set var="dispo12" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo12}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo12}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">12:30</th>
			<c:set var="dispo1230" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '12:30'}">
    				<c:set var="dispo1230" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1230}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1230}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">13:00</th>
			<c:set var="dispo13" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '13:00'}">
    				<c:set var="dispo13" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo13}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo13}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		<tr>
			<th scope="row">13:30</th>
			<c:set var="dispo1330" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '13:30'}">
    				<c:set var="dispo1330" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1330}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1330}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">14:00</th>
			<c:set var="dispo14" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '14:00'}">
    				<c:set var="dispo14" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo14}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo14}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">14:30</th>
			<c:set var="dispo1430" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '14:30'}">
    				<c:set var="dispo1430" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1430}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1430}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">15:00</th>
			<c:set var="dispo15" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '15:00'}">
    				<c:set var="dispo15" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo15}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo15}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">15:30</th>
			<c:set var="dispo1530" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '15:30'}">
    				<c:set var="dispo1530" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1530}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1530}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">16:00</th>
			<c:set var="dispo16" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '16:00'}">
    				<c:set var="dispo16" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo16}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo16}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">16:30</th>
			<c:set var="dispo1630" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '16:30'}">
    				<c:set var="dispo1630" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1630}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1630}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">17:00</th>
			<c:set var="dispo17" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '17:00'}">
    				<c:set var="dispo17" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo17}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo17}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">17:30</th>
			<c:set var="dispo1730" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '17:30'}">
    				<c:set var="dispo1730" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1730}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1730}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">18:00</th>
			<c:set var="dispo18" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '18:00'}">
    				<c:set var="dispo18" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo18}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo18}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">18:30</th>
			<c:set var="dispo1830" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '18:30'}">
    				<c:set var="dispo1830" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo1830}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo1830}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
		
		<tr>
			<th scope="row">19:00</th>
			<c:set var="dispo19" value="true" scope="page" />
			<c:forEach items="${ creneaux }" var="creneau"> 
    		<c:if test = "${creneau == '19:00'}">
    				<c:set var="dispo19" value="false" scope="page" />
 				</c:if> 
			</c:forEach>
			
			<c:if test = "${dispo19}"> 
				<td style="background-color:green; color:white; font-weight:bold;">disponible</td>
		 	</c:if>
		 	
		 	<c:if test = "${!dispo19}"> 
				<td style="background-color:salmon; color:white; font-weight:bold;">complet</td>
		 	</c:if>
		</tr>
	</table>
	<br>
	<form style="top:50px; left:25px; position:absolute;" method="post" action="reservation">
<p>Choix parmi les creneaux disponiblbes</p>
<select style="width:200px; border-radius:25px; border: 1px solid gold;" name="session" id="session">
<c:if test = "${dispo8}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 08:00">08:00</option>
</c:if>
<c:if test = "${dispo830}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 08:30">08:30</option>
</c:if>
<c:if test = "${dispo9}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 09:00">09:00</option>
</c:if>
<c:if test = "${dispo930}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 09:30">09:30</option>
</c:if>
<c:if test = "${dispo10}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 10:00">10:00</option>
</c:if>
<c:if test = "${dispo1030}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 10:30">10:30</option>
</c:if>
<c:if test = "${dispo11}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 11:00">11:00</option>
</c:if>
<c:if test = "${dispo1130}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 11:30">11:30</option>
</c:if>
<c:if test = "${dispo12}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 12:00">12:00</option>
</c:if>
<c:if test = "${dispo1230}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 12:30">12:30</option>
</c:if>
<c:if test = "${dispo13}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 13:00">13:00</option>
</c:if>
<c:if test = "${dispo1330}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 13:30">13:30</option>
</c:if>
<c:if test = "${dispo14}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 14:00">14:00</option>
</c:if>
<c:if test = "${dispo1430}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 14:30">14:30</option>
</c:if>
<c:if test = "${dispo15}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 15:00">15:00</option>
</c:if>
<c:if test = "${dispo1530}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 15:30">15:30</option>
</c:if>
<c:if test = "${dispo16}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 16:00">16:00</option>
</c:if>
<c:if test = "${dispo1630}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 16:30">16:30</option>
</c:if>
<c:if test = "${dispo17}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 17:00">17:00</option>
</c:if>
<c:if test = "${dispo1730}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 17:30">17:30</option>
</c:if>
<c:if test = "${dispo18}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 18:00">18:00</option>
</c:if>
<c:if test = "${dispo1830}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 18:00">18:30</option>
</c:if>
<c:if test = "${dispo19}">
<option value="<c:out value="${ medecin }" />,<c:out value="${ patient }" />,<c:out value="${ date }" /> 19:00">19:00</option>
</c:if>

</select>

<br><br>

<input type="submit"/>

</form>
</body>
</html>