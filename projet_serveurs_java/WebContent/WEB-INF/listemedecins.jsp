<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ListeMedecins</title>
	<link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/cover/">
<style>

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

table {
    border-collapse: collapse;
    border: 2px solid rgb(200, 200, 200);
    letter-spacing: 1px;
    font-family: sans-serif;
    font-size: .8rem;
}


html, body {
	height:100%;
	width:100%;
}

#liste {
	position : relative;
	top : 10%;
	height: 80%;
	width: 90%;
	left: 5%;
}

#liste table {
	width: 100%;
	position: absolute;
	overflow-y: scroll;
}

/* Button 1 */
.btn-1 {
	border: 3px solid #fff;
	color: #fff;
}

/* Button 1a */
.btn-1a:hover,
.btn-1a:active {
	color: #0e83cd;
	background: #fff;
}

/* General button style (reset) */
.btn {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 25px 80px;
	display: inline-block;
	margin: 15px 30px;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-weight: 700;
	outline: none;
	position: relative;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.btn:after {
	content: '';
	position: absolute;
	z-index: -1;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

/* Pseudo elements for icons */
.btn:before,
.icon-heart:after,
.icon-star:after,
.icon-plus:after,
.icon-file:before {
	font-family: 'icomoon';
	speak: none;
	font-style: normal;
	font-weight: normal;
	font-variant: normal;
	text-transform: none;
	line-height: 1;
	position: relative;
	-webkit-font-smoothing: antialiased;
}

/* General Demo Style */
@import url(https://fonts.googleapis.com/css?family=Lato:300,400,700);

@font-face {
	font-family: 'codropsicons';
	src:url('../fonts/codropsicons/codropsicons.eot');
	src:url('../fonts/codropsicons/codropsicons.eot?#iefix') format('embedded-opentype'),
		url('../fonts/codropsicons/codropsicons.woff') format('woff'),
		url('../fonts/codropsicons/codropsicons.ttf') format('truetype'),
		url('../fonts/codropsicons/codropsicons.svg#codropsicons') format('svg');
	font-weight: normal;
	font-style: normal;
}

</style>
</head>

<body style="background-color:teal;">
<br><br><br>
<h2 style="color:white;font-weight:bold;text-align:center;">Liste des medecins</h2>
<button class="btn btn-1 btn-1d">Button</button>
<div id="liste">
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
</div>

<script type="text/javascript">
/*!
 * classie - class helper functions
 * from bonzo https://github.com/ded/bonzo
 * 
 * classie.has( elem, 'my-class' ) -> true/false
 * classie.add( elem, 'my-new-class' )
 * classie.remove( elem, 'my-unwanted-class' )
 * classie.toggle( elem, 'my-class' )
 */

/*jshint browser: true, strict: true, undef: true */
/*global define: false */

( function( window ) {

'use strict';

// class helper functions from bonzo https://github.com/ded/bonzo

function classReg( className ) {
  return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
}

// classList support for class management
// altho to be fair, the api sucks because it won't accept multiple classes at once
var hasClass, addClass, removeClass;

if ( 'classList' in document.documentElement ) {
  hasClass = function( elem, c ) {
    return elem.classList.contains( c );
  };
  addClass = function( elem, c ) {
    elem.classList.add( c );
  };
  removeClass = function( elem, c ) {
    elem.classList.remove( c );
  };
}
else {
  hasClass = function( elem, c ) {
    return classReg( c ).test( elem.className );
  };
  addClass = function( elem, c ) {
    if ( !hasClass( elem, c ) ) {
      elem.className = elem.className + ' ' + c;
    }
  };
  removeClass = function( elem, c ) {
    elem.className = elem.className.replace( classReg( c ), ' ' );
  };
}

function toggleClass( elem, c ) {
  var fn = hasClass( elem, c ) ? removeClass : addClass;
  fn( elem, c );
}

var classie = {
  // full names
  hasClass: hasClass,
  addClass: addClass,
  removeClass: removeClass,
  toggleClass: toggleClass,
  // short names
  has: hasClass,
  add: addClass,
  remove: removeClass,
  toggle: toggleClass
};

// transport
if ( typeof define === 'function' && define.amd ) {
  // AMD
  define( classie );
} else {
  // browser global
  window.classie = classie;
}

})( window );

</script>
</body>
</html>