package Servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Conjunto;
import service.ConjuntoService;

/**
 * Servlet implementation class ConsultarServlet
 */
@WebServlet("/AlterarServlet")
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarServlet() {
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
		// TODO Auto-generated method stub
		

		String id = request.getParameter("idConjunto");
		String acao = (request.getParameter("acao"));

		// javabean
		Conjunto conjunto = new Conjunto();
		

		// service
		ConjuntoService cs = new ConjuntoService();

		// enviar parametros para o jsp
		if (acao.equals("consultar")) {
			conjunto = cs.consultarConjunto(Integer.parseInt(id));

			request.setAttribute("conjunto", conjunto);

			RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarConjunto.jsp");
			dispatcher.forward(request, response);
		}

		if (acao.equals("alterar")) {
			String status = request.getParameter("status");
			String valor = request.getParameter("valor");
			String medida = request.getParameter("medida");
			String tempoLocacao = request.getParameter("tempoLocacao");
			String observacao = request.getParameter("observacao");
			
			conjunto.setId_conjunto(Integer.parseInt(id));
			conjunto.setStatus(Boolean.parseBoolean(status));
			conjunto.setValor(Double.parseDouble(valor));
			conjunto.setMedida(Double.parseDouble(medida));
			conjunto.setTempoLocacao(Integer.parseInt(tempoLocacao));
			conjunto.setObservacao(observacao);
			
			cs.alterarConjunto(conjunto);
			
			request.setAttribute("conjunto", conjunto);

			RequestDispatcher dispatcher = request.getRequestDispatcher("AlterarConjunto.jsp");
			dispatcher.forward(request, response);

		}
	}

}
