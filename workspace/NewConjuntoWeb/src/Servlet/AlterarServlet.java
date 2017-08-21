package Servlet;

import java.io.IOException;
import java.util.ArrayList;

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
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		String Id = request.getParameter("id");

		int id = -1;

		try {
			id = Integer.parseInt(Id);
		} catch (NumberFormatException e) {
		}

		String acao = (request.getParameter("acao"));

		// javabean
		Conjunto conjunto = new Conjunto();
		ArrayList<Conjunto> lista = new ArrayList<Conjunto>();

		// service
		ConjuntoService cs = new ConjuntoService();

		// enviar parametros para o jsp
		if (acao.equals("Editar")) {
			conjunto = cs.consultarConjunto(id);
			lista = (ArrayList<Conjunto>) session.getAttribute("lista");

			request.setAttribute("conjunto", conjunto);
			Id = request.getParameter("id");

			try {
				id = Integer.parseInt(Id);
			} catch (NumberFormatException e) {
			}

			view = request.getRequestDispatcher("AlterarConjunto.jsp");
		}

		if (acao.equals("alterar")) {
			String id_conjunto = request.getParameter("id_conjunto");
			String status = request.getParameter("status");
			String valor = request.getParameter("valor");
			String medida = request.getParameter("medida");
			String tempoLocacao = request.getParameter("tempoLocacao");
			String observacao = request.getParameter("observacao");

			conjunto.setId_conjunto(Integer.parseInt(id_conjunto));
			conjunto.setStatus(Boolean.parseBoolean(status));
			conjunto.setValor(Double.parseDouble(valor));
			conjunto.setMedida(Double.parseDouble(medida));
			conjunto.setTempoLocacao(Integer.parseInt(tempoLocacao));
			conjunto.setObservacao(observacao);

			cs.alterarConjunto(conjunto);

			int pos = busca(conjunto, lista);
//			lista.remove(pos);
//			lista.add(pos, conjunto);
//			session.setAttribute("lista", lista);
			request.setAttribute("conjunto", conjunto);
			view = request.getRequestDispatcher("ConsultarConjunto.jsp");

		}
		if (acao.equals("Voltar")) {
			view = request.getRequestDispatcher("ListaConjuntos.jsp");
		}

		view.forward(request, response);

	}

	public int busca(Conjunto conjunto, ArrayList<Conjunto> lista) {
		Conjunto to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId_conjunto() == conjunto.getId_conjunto()) {
				return i;
			}
		}
		return -1;
	}

}
