package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Conjunto;
import service.ConjuntoService;

/**
 * Servlet implementation class ConjuntoServlet
 */
@WebServlet("/ConjuntoServlet.do")
public class ConjuntoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConjuntoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = request.getParameter("status");
		String valor = request.getParameter("valor");
		String medida = request.getParameter("medida");
		String tempoLocacao = request.getParameter("tempoLocacao");
		String observacao = request.getParameter("observacao");
		// String oQueFazer = (request.getParameter("oQueFazer"));
		String acao = (request.getParameter("acao"));
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		

		// javabean
		Conjunto conjunto = new Conjunto();
		conjunto.setStatus(Boolean.parseBoolean(status));
		conjunto.setValor(Double.parseDouble(valor));
		conjunto.setMedida(Double.parseDouble(medida));
		if(tempoLocacao == null)
		{
			conjunto.setTempoLocacao(0);
		}
		else
		conjunto.setTempoLocacao(Integer.parseInt(tempoLocacao));
		
		conjunto.setObservacao(observacao);
		//int id = -1;

		// service
		ConjuntoService cs = new ConjuntoService();
		cs.criarConjunto(conjunto);
		

		// enviar parametros para o jsp
		if (acao.equals("cadastrar"))
		{
		conjunto.setId_conjunto(cs.consultarNumero());
		request.setAttribute("conjunto", conjunto);

		view = request.getRequestDispatcher("NumConjuntoCadastrado.jsp");
		
		
		}
		
		view.forward(request, response);

	}

}
