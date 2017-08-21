<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

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
<script type="text/javascript" src="http://www.queness.com/js/bsa.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link href="css/formulario.css" rel="stylesheet">


</head>

<body>

	


	<form action="ConjuntoServlet.do" method="post">
		<c:import url="Menu.jsp" />
		<div id="contact-form">
			<div>
				<h1>Cadastre seu conjunto</h1>
			</div>
			<label for="status"> <Span class="required">Status:</span><br>
				<input type="radio" name="status" id="contact-radio" value="true"
				onclick="if(document.getElementById('tempoLocacao').disabled==true){document.getElementById('tempoLocacao').disabled=false}">
				Ocupado <br> <input type="radio" name="status" id="Desocupado"
				value="false"
				onclick="if(document.getElementById('tempoLocacao').disabled==false){document.getElementById('tempoLocacao').disabled=true}"
				checked> Desocupado <br> <br>
			</label>

			<div>
				<span class="required">Valor do aluguel:</span><br> <input
					type="number" id="valor " name="valor"
					placeholder="Valor do aluguel mensal" tabindex="2"
					required="required">

			</div>
			<div>
				<span class="required">Tamanho do conjunto:</span><br> <input
					type="number" id="medida" name="medida" placeholder="Medida em m²"
					tabindex="3" required="required">

			</div>
			<div>
				<span class="required">Tempo de locação:</span><br> <input
					type="number" id="tempoLocacao" name="tempoLocacao"
					disabled="disabled" placeholder="Quantidade de meses do aluguel"
					tabindex="4" required="required">

			</div>
			<div>
				<span class="required">Observações:</span>
				<textarea id="obs" name="observacao"
					placeholder="Observações do conjunto" tabindex="5"></textarea>

			</div>

			<div>

				<button type="submit" name="acao" value="cadastrar" class="btn btn-danger btn-xs">Cadastrar</button>
	</div>			
		</div>
	</form>



	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>


	

</body>

</html>