package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Conjunto;
import service.ConjuntoService;

/**
 * Servlet implementation class ManterConjuntoController
 */
@WebServlet("/ManterConjuntoController.do")
public class ManterConjuntoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("idConjunto"));
		} catch (Exception e) {
		}
		
		String status = request.getParameter("status");
		boolean status2 = false;
		switch (status) {
		case "Disponivel":
			status2 = true;
			break;
		case "Indisponivel":
			status2 = false;
			break;
		}
		Double valor=0.0;
		try {
			valor = Double.parseDouble(request.getParameter("valorConjunto"));
		} catch (Exception e) {
		}
		Double tempoLocacao =0.0;
		try {
			tempoLocacao = Double.parseDouble(request.getParameter("tempoLocacaoConjunto"));
		} catch (Exception e) {
		}
		Double medida=0.0;
		try {
			medida = Double.parseDouble(request.getParameter("medidaConjunto"));
		} catch (Exception e) {
		}
		String observacao = request.getParameter("observacaoConjunto");

	
		Conjunto conjunto = new Conjunto(id, status2, valor, tempoLocacao,medida,observacao);
		ConjuntoService service = new ConjuntoService();
		PrintWriter out = response.getWriter();
		
		String oQueFazer = request.getParameter("oQueFazer");
		switch (oQueFazer) {
		case "Cadastrar":
			out.println("<html> "
					+ "<body> <header> <h1>Cadastro realizado com sucesso</h1> </header> "
					+"<p> Dados do cojnunto:"+conjunto.getMedida()+"/"+conjunto.getStatus()+"/"+conjunto.getObservacao()+"/"+conjunto.getTempoLocacao()+"</p>"+ "</body> </html>");
			service.criar(conjunto);
			out.println("<html> "
					+ "<body> <header> <h1>Cadastro realizado com sucesso</h1> </header> "
					+ "<p>O cliente com o ID <b>" + service.retornaUltimoId(conjunto) + "</b> foi cadastrado com sucesso</p>"
					+ "<form action="+ "http://localhost:8080/Treino/index.html" +">"
					+ "<input type="+"submit"+" value="+"Voltar"+" />"
					+ "</body> </html>");			
			out.close();
			//request.setAttribute("Mensagem", "Cliente cadastrado com sucesso!");
			break;
		case "Consultar":
			conjunto = service.carregar(conjunto.getIdConjunto());
			out.println("<html> "
					+ "<body> <header> <h1>Cadastro realizado com sucesso</h1> </header> "
					+ "<p>O ID do conjunto é: <b>" + conjunto.getIdConjunto() + "</b></p>"
					+ "<p>O status é: <b>" + conjunto.getStatus() + "</b></p>"
					+ "<p>O valor do conjunto é: <b>" + conjunto.getValor() + "</b></p>"
					+ "<p>O tempo de locação do cojunto é: <b>" + conjunto.getTempoLocacao() + "</b></p>"
					+ "<p>A medida do conjunto é: <b>" + conjunto.getMedida() + "</b></p>"
					+ "<p>Observações do conjunto: <b>" + conjunto.getObservacao() + "</b></p>"			
					+ "<form action="+ "http://localhost:8080/Treino/index.html" +">"
					+ "<input type="+"submit"+" value="+"Voltar"+" />"
					+ "</body> </html>");
			out.close();
			//request.setAttribute("Mensagem", "Cliente consultado com sucesso!");
			break;
		case "Remover":
			service.excluir(conjunto.getIdConjunto());
			out.println("<html> "
					+ "<body> <header> <h1>Exclusão realizado com sucesso</h1> </header> "
					+"<p> Dados do conjunto excluido</p>"+ "<form action="+ "http://localhost:8080/Treino/index.html" +">"
					+ "<input type="+"submit"+" value="+"Voltar"+" />"+ "</body> </html>");
			out.close();
			//request.setAttribute("Mensagem", "Cliente deletado com sucesso!");
			break;
		case "Atualizar":
			service.atualizar(conjunto);
			out.println("<html> "
					+ "<body> <header> <h1>Atualização realizado com sucesso</h1> </header> "
					+"<p> Dados do conjunto atualizada</p>"+ "<form action="+ "http://localhost:8080/Treino/index.html" +">"
					+ "<input type="+"submit"+" value="+"Voltar"+" />"+ "</body> </html>");
			out.close();
			//request.setAttribute("Mensagem", "Cliente atualizado com sucesso!");
			break;
		}

		//request.setAttribute("conjunto", conjunto);
		//request.setAttribute("oQueFazer", oQueFazer);

		//RequestDispatcher dispatch = request.getRequestDispatcher("Cliente.jsp");
		//dispatch.forward(request, res
	}
}

