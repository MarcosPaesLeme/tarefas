<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	<h1>Exclua seu conjunto</h1>
	</div>
		<p id="failure">Ops! Conjunto não cadastrado</p>  
		<p id="success">Seu conjunto foi cadastrado com sucesso!</p>
	


	<form action="ExcluirServlet" method="post">
	<div>
	<label for="id">	
	<span class ="required">Digite o id do conjunto:</span>	
	<input type="text" name="idConjunto" id="idConjunto" value="" />
	
	</label>
	</div>
		<div>
		<label for="status">
		<span class ="required">Status:</span>	
		<input type="text" value="${conjunto.status}" name="status">		
		</label>
		</div>
		<div>
		
		<p>Valor do aluguel:</p>
		<input type="text" value="${conjunto.valor}" name="valor">
		</div>
		<div>
		<label for="medida">
		<span class ="required">Tamanho do conjunto:</span>
		<input type="text" value="${conjunto.medida}" name="medida">
		</label>
		</div>
		<div>
		<label for="tempo">
		<span class ="required">Tempo de locação:</span>
		<input type="text" value="${conjunto.tempoLocacao}" name="tempoLocacao">
		</label>
		</div>
		<div>
		<label for="obs">
		<span class ="required">Observações:</span>
		<textarea name="observacao" >${conjunto.observacao} </textarea>
		</label>
		</div>
		<div>
			<button name="acao" value="consultar" type="submit" >Consultar</button><br>
			</div>
			<div>
			<button name="acao" value="excluir" type="submit" >Excluir</button><br>
		</div>
		</form>
	</div>
		
			
		</body>
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>



</html>