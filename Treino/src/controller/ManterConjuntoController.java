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
		
		
		String oQueFazer = request.getParameter("oQueFazer");
		switch (oQueFazer) {
		case "Cadastrar":
			int ultimoID = 0;
			service.criar(conjunto);
			ultimoID = service.retornaUltimoId(conjunto); 
			request.setAttribute("resultado", "Conjunto cadastrado com sucesso. O registro dele é:"+ultimoID);
			break;
		case "Consultar":
			conjunto = service.carregar(conjunto.getIdConjunto());
			request.setAttribute("resultado", "Conjunto consultado com sucesso"+"ID:"+conjunto.getIdConjunto()+"Status"+conjunto.getStatus()+"Valor"+conjunto.getValor()+"Tempo alocacao:"+conjunto.getTempoLocacao()+"Medida"+conjunto.getMedida()+"Observações"+conjunto.getObservacao());
			break;
		case "Remover":
			service.excluir(conjunto.getIdConjunto());
			request.setAttribute("resultado", "Conjunto excluido!!!");
			break;
		case "Atualizar":
			service.atualizar(conjunto);
			request.setAttribute("resultado", "Conjunto atulizado com sucesso");
			break;
		}

		request.setAttribute("conjunto", conjunto);
		request.setAttribute("oQueFazer", oQueFazer);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("Conjunto.jsp");
		dispatch.forward(request, response);
	}
}

