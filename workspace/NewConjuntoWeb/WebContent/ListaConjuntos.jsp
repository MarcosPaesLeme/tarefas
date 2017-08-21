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
<link rel="stylesheet" href="css/main2.css" />
<script type="text/javascript" src="js/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="js/gnmenu.js"></script>
<script type="text/javascript" src="http://www.queness.com/js/bsa.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>


	<!-- Modal -->
	<div class="modal fade" id="delete-modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Fechar">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Excluir conjunto</h4>
				</div>
				<div class="modal-body">Deseja realmente excluir este conjunto?
				</div>
				<div class="modal-footer">
					<form action="ExcluirServlet" method="post">
						<input type="hidden" name="id" id="id_excluir" />
						<button type="submit" class="btn btn-primary" name="acao"
							value="Excluir">Sim</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- /.modal -->

	<c:import url="Menu.jsp" />

	<div id="main" class="container">
		<form action="ListarConjuntos" method="post">
			<div id="top" class="row">
				<div class="col-md-3">
					
				</div>

				<div class="col-md-6">
					<div class="input-group h2">
						<input name="data[search]" class="form-control" id="search"
							type="text" placeholder="Pesquisar conjuntos"> <span
							class="input-group-btn">
							<button class="btn btn-primary" type="submit" name="acao"
								value="buscar">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>

			</div>

		</form>
		<hr />
			
		<c:if test="${not empty lista}">
			<div id="listaConjuntos" class="row">
				<div class="table-responsive col-md-12">
				<input type="text" name="existe" value="${existe}" style="background-color:#d2e7fd; Border:0" disabled>
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead >
							<tr>
								<th><center>Número</center></th>
								<th><center>Tamanho</center></th>
								<th><center>Valor do aluguel</center></th>
								<th><center>Status</center></th>
								<th class="actions"/>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="conjunto" items="${lista}">
								<tr>
									<td>${conjunto.id_conjunto}</td>
									<td>${conjunto.medida}</td>
									<td>${conjunto.valor}</td>
									<td>${conjunto.status}</td>
									
									<td class="actions"><a class="btn btn-success btn-xs"
										href="ConsultarServlet?acao=Visualizar&id=${conjunto.id_conjunto}">Visualizar</a>
										<a class="btn btn-warning btn-xs"
										href="AlterarServlet?acao=Editar&id=${conjunto.id_conjunto}">Editar</a>
										<button id="btn${conjunto.id_conjunto}%>" type="button"
											class="btn btn-danger btn-xs" data-toggle="modal"
											data-target="#delete-modal"
											data-cliente="${conjunto.id_conjunto}">Excluir</button></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</div>


	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#delete-modal").on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); //botao que disparou a modal
			var recipient = button.data('cliente');
			$("#id_excluir").val(recipient);
		});
	</script>
</body>

</html>