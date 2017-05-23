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



<link rel="stylesheet" href="css/normalize.css" />
<link rel="stylesheet" href="css/main.css" />
<script type="text/javascript" src="js/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="js/gnmenu.js"></script>
<script type="text/javascript" src="js/bootbox.min.js"></script>
<script type="text/javascript" src="http://www.queness.com/js/bsa.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
<link href="css/formulario.css" rel="stylesheet">
<link href="css/msc-style.css" rel="stylesheet">

</head>
<body>
<c:import url = "Menu.jsp"/>
<div id="contact-form">
<div>
	<h1>Altere seu conjunto</h1>
	</div>
	


	<form action="AlterarServlet" method="post">

	<div>
		<span class ="required">Id do conjunto:</span><br>
		<input type="number" value="${conjunto.id_conjunto}" name="id_conjunto" id="id_conjunto" readonly>
		</div>
		
		<div>
		<label for="status">
		<span class ="required">Status:</span>	<br>
		<input type="radio" name="status" id="status" value="true" <c:if test="${conjunto.status == true}">checked</c:if>>  Ocupado  <br>
		<input type="radio" name="status" id="status" value="false" <c:if test="${conjunto.status == false}">checked</c:if>>  Desocupado <br><br>
			<br>		
		</label>
		</div>	
		<div>
		
		<span class ="required">Valor do aluguel:</span><br>
		<input type="number" value="${conjunto.valor}" name="valor" id="valor">
		</div>
		<div>
		
		
		<span class ="required">Tamanho do conjunto:</span><br>
		<input type="number" value="${conjunto.medida}" name="medida" id="medida">
		
		</div>
		<div>
		
		
		<span class ="required">Tempo de locação:</span><br>
		<input type="number" value="${conjunto.tempoLocacao}" name="tempoLocacao" id="tempoLocacao">
		
		</div>
		<div>
		
		<span class ="required">Observações:</span><br>
		<textarea name="observacao" id="observacao">${conjunto.observacao} </textarea>
		
		</div>	
			<div>
			<a href="ConsultarConjunto.jsp">
			<button name="acao" value="alterar" type="submit" onClick="myFunction()" class="btn btn-primary" >Alterar</button><br>
			</a>
		</div>
		<a href="ListarConjuntos?acao=reiniciar">
					<button name="acao" value="Voltar" type="submit">Voltar</button>
				</a>
		</form>
		
		
	</div>
		<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/msc-script.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootbox.min.js"></script>



	<script>
		function myFunction() {
			alert('Alterações realizadas com sucesso');
		}
	</script>
		
</body>



</html>