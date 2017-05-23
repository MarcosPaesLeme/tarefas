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
@WebServlet("/ExcluirServlet")
public class ExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcluirServlet() {
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

		// service
		ConjuntoService cs = new ConjuntoService();

		// enviar parametros para o jsp
	

		if (acao.equals("Excluir")) {

			conjunto.setId_conjunto(id);
			cs.excluirConjunto(conjunto);
			ArrayList<Conjunto> lista = (ArrayList<Conjunto>)session.getAttribute("lista");
			lista.remove(busca(conjunto, lista));
			session.setAttribute("lista", lista);

			view = request.getRequestDispatcher("ListaConjuntos.jsp");

		}
		
		view.forward(request, response);
	}
	
	public int busca(Conjunto conjunto, ArrayList<Conjunto> lista) {
		Conjunto to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId_conjunto() == conjunto.getId_conjunto()){
				return i;
			}
		}
		return -1;
	}

}
