<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">




<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="js/gnmenu.js"></script>
<link href="css/formulario.css" rel="stylesheet">


</head>
<body>

	<c:import url="Menu.jsp" />

	<div id="contact-form">
		<div>
			<h2>Número do conjunto cadastrado:</h2><br><br>
				<center><h1>${conjunto.id_conjunto}</h1></center><br>
		</div>

		<div>
			<a href="index.jsp">
				<button type="submit" name="acao" value="ok">Ok</button>
			</a>
		</div>
	</div>
</body>

</html>