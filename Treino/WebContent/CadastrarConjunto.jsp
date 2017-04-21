<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link href="css/formulario.css" rel="stylesheet">

</head>
<body>

<div id="contact-form">
<div>
	<h1>Cadastre seu conjunto</h1>
	</div>
		<p id="failure">Ops! Conjunto não cadastrado</p>  
		<p id="success">Seu conjunto foi cadastrado com sucesso!</p>
	


	<form action="ConjuntoServlet.do" method="post">
		<div>
		<label for="status">
		<span class ="required">Status:</span>
		<input type="radio" name="status" id="Ocupado" value="true" />Ocupado<br />
		<input type="radio" name="status" id="Desocupado"  value="false" />Desocupado<br />
		</label>
		</div>
		<div>
		<label for="valor">
		<span class ="required">Valor do aluguel:</span>
		<input type="number" name="valor" placeholder="Valor do aluguel mensal" tabindex="2"
		required="required">
		</label>
		</div>
		<div>
		<label for="medida">
		<span class ="required">Tamanho do conjunto:</span>
		<input type="number" name="medida" placeholder="Medida em m²" tabindex="3"
		required="required">
		</label>
		</div>
		<div>
		<label for="tempo">
		<span class ="required">Tempo de locação:</span>
		<input type="number" name="tempoLocacao" placeholder="Quantidade de meses do aluguel" tabindex="4"
		required="required">
		</label>
		</div>
		<div>
		<label for="tempo">
		<span class ="required">Observações:</span>
		<textarea id="obs" name="observacao" 	placeholder="Observações do conjunto" tabindex="5" ></textarea>
		</label>
		</div>
		<div>
			<button name="acao" type="submit" onClick="cs.criarConjunto(conjunto)">Cadastrar</button><br>
			</div>
			<div>
			<button type="submit" value="Voltar" onClick="history.go(-1)">Voltar </button>
		</div>
		</form>
	</div>
		
			
		</body>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>



</html>